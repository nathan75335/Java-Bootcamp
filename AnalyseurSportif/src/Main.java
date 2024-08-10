import java.util.*;
public class Main {
    public static void main(String[] args) {

        /*
            Projet 18 : Analyseur de Données Sportives Objectif du Projet
            Créer une application qui analyse les performances sportives et affiche des statistiques telles que le nombre de victoires, de défaites, et les scores moyens.
            Description du Programme
            Le programme analyse les données de performances sportives et fournit un résumé statistique.
            Fonctionnalités
            • Saisie des données de performances.
            • Calcul et affichage des statistiques.
            Instructions de Développement
            1. Utiliser des structures de données pour stocker les performances.
            2. Implémenter des méthodes pour calculer et afficher les statistiques.
            Extension Potentielle
            • Comparer les performances de plusieurs équipes.
            • Ajouter des graphiques pour visualiser les performances.
         */
        //les equipes
        Scanner scanner = new Scanner(System.in);
        List<String> teams = new ArrayList<>();
        //le nom de l equipe / la liste des scores 1 si l equipe a gagne et 0 si l equipe a fait null et -1 si l equipe perdu
        HashMap<String, List<Integer>> performances = new HashMap<>();

       while (true){
           System.out.println("Analyser of sportif data! You are welcome...");

           System.out.println(" 1. Add A Team");
           System.out.println((" 2. Remove Team"));
           System.out.println(" 3. Enter the performance of a team: 1 if the team won, 0 if null, and -1 if the team lost");
           System.out.println(" 4. Show Team performances");
           System.out.println(" 5. Compare team performances");
           System.out.println(" 6. Show Graphic representation of teams performance");
           System.out.println(" 7. Exit");
           int choice =  scanner.nextInt();
           switch (choice){
               case 1:
                   System.out.println("Enter the name of the team:");
                   teams.add(scanner.next());
                   break;
               case 2:
                   System.out.println("Enter the name of the team you want to remove:");
                    removeTeam(teams, scanner.nextLine());
                    break;
               case 3:
                   System.out.println("Enter the name of the team you want to enter performance:");
                   String teamName = scanner.next();
                   System.out.println("Enter the performance of a team:");
                   int performanceValue = scanner.nextInt();

                   var isInputDataValid = isDataInputValidvalidate(teams, teamName, performanceValue);

                   if(isInputDataValid){
                       addTeamPerformance(performances, teamName, performanceValue);
                   }
                   break;
               case 4:
                    System.out.println("Enter the name of the team you want to show:");
                    String team = scanner.nextLine();

                    if(!isTeamExist(teams, team)){
                        System.out.println("Team " + team + " does not exist!");
                        break;
                    }

                    showResult(getTeamPerformance(performances, team));
                    break;
               case 5:
                    compareTeamPerformances(performances);
                    break;
               case 6:
                    var teamPerformances = getTeamsPerformances(performances);
                    generateBarPlot(teamPerformances);
                   break;

               case 7:
                   System.exit(0);
                   break;
                   default:break;

           }
       }
    }

    public static void removeTeam(List<String> teams, String team){
        for(int i = 0; i < teams.size(); i++){
            if(teams.get(i).toLowerCase().equals(team.toLowerCase())){
                teams.remove(i);
            }
        }
    }

    public static void addTeamPerformance(HashMap<String, List<Integer>> performances, String team, int performanceValue){
        List<Integer> teamPerformances = new ArrayList<>();

        if(performances.containsKey(team)){
            teamPerformances = performances.get(team);
            teamPerformances.add(performanceValue);
            performances.put(team, teamPerformances);
        }else{
            teamPerformances.add(performanceValue);
            performances.put(team, teamPerformances);
        }
    }

    public static boolean isDataInputValidvalidate(List<String> teams,String team, int performanceValue){
        var isInputDataValid = true;
        if(!isTeamExist(teams, team)){
            System.out.println("Team " + team + " does not exist!");
            isInputDataValid = false;
        }

        //la performance doit etre egale a 1, -1 ou 0
        if(performanceValue != 1 && performanceValue != -1 && performanceValue != 0){
            System.out.println(" the performance must be equal to 1, -1 or 0");
            isInputDataValid = false;
        }

        return isInputDataValid;
    }

    public static boolean isTeamExist(List<String> teams, String team){
        if(!teams.contains(team)){
            return false;
        }

        return true;
    }

    public static List<Integer> getTeamPerformance(HashMap<String, List<Integer>> performances, String team){

        var teamPerformances = performances.get(team);
        int numberOfLosses = 0;
        int numberOfWins = 0;
        int numberofNulls = 0;

        for(int i = 0; i < teamPerformances.size(); i++){
            if(teamPerformances.get(i).equals(1)){
                numberOfWins ++;
            }else if(teamPerformances.get(i).equals(-1)){
                numberOfLosses ++;
            }
            else{
                numberofNulls ++;
            }

        }

        List<Integer> results = new ArrayList<>();
        results.add(numberOfWins);
        results.add(numberOfLosses);
        results.add(numberofNulls);

        return  results;
    }

    public static void showResult(List<Integer> results){
        System.out.println("The team has won "+ results.get(0) + " games, lost "+ results.get(1) + "games!"+ " and nulls "+ results.get(2));
    }

    public static void showResult(List<Integer> result, String team){
        System.out.println("The team "+ team + "has won "+ result.get(0) + " games, lost "+ result.get(1) + "games!"+ " and nulls "+ result.get(2));
    }

    public static void compareTeamPerformances(HashMap<String, List<Integer>> performances){
        //List
        HashMap<String, List<Integer>> teamsWithWinLossAndNulls = getTeamsPerformances(performances);

        var sortedPerformances =  sortHashMapByValue(teamsWithWinLossAndNulls);

        for(String team : sortedPerformances.keySet()){
            var teamPerformances = sortedPerformances.get(team);
            showResult(teamPerformances, team);
        }
    }

    public static HashMap<String, List<Integer>> getTeamsPerformances(HashMap<String, List<Integer>> performances){
        HashMap<String, List<Integer>> teamsWithWinLossAndNulls = new HashMap<>();

        for(String team : performances.keySet()){
            var teamWinLossNulls = getTeamPerformance(performances, team);
            teamsWithWinLossAndNulls.put(team, teamWinLossNulls);
        }

        return teamsWithWinLossAndNulls;
    }

    public static HashMap<String, List<Integer>> sortHashMapByValue(HashMap<String, List<Integer>> hm)
    {

        List<Map.Entry<String, List<Integer>>> list =
                new LinkedList<Map.Entry<String, List<Integer>>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, List<Integer>>>() {
            public int compare(Map.Entry<String, List<Integer>> o1,
                               Map.Entry<String, List<Integer>> o2)
            {

                if (o1.getValue().get(0) != o2.getValue().get(0)) {
                    return Integer.compare(o2.getValue().get(0), o1.getValue().get(0));
                }

                if (o1.getValue().get(1) != o2.getValue().get(1)) {
                    return Integer.compare(o1.getValue().get(1), o2.getValue().get(1));
                }

                return Integer.compare(o1.getValue().get(2), o2.getValue().get(2));
            }
        });

        HashMap<String, List<Integer>> temp = new LinkedHashMap<String, List<Integer>>();
        for (Map.Entry<String, List<Integer>> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static void generateBarPlot(HashMap<String, List<Integer>> data) {
        System.out.printf("%-10s %-15s %-15s %-15s%n", "Teams", "Wins", "Losses", "Nulls");

        for (Map.Entry<String, List<Integer>> entry : data.entrySet()) {
            String category = entry.getKey();
            List<Integer> stats = entry.getValue();

            String winsBar = generateBar(stats.get(0));
            String lossesBar = generateBar(stats.get(1));
            String nullsBar = generateBar(stats.get(2));

            System.out.printf("%-10s %-15s %-15s %-15s%n", category, winsBar, lossesBar, nullsBar);
        }
    }

    public static String generateBar(int count) {
        return "#".repeat(count);
    }
}