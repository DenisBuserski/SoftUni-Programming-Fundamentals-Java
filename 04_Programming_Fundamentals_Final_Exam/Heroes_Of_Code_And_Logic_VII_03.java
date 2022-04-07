import java.util.*;

public class Heroes_Of_Code_And_Logic_VII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> heroData = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfHeroes; i++) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            String heroName = inputArray[0];
            int heroHP = Integer.parseInt(inputArray[1]);
            int heroMP = Integer.parseInt(inputArray[2]);
            heroData.put(heroName, Arrays.asList(heroHP, heroMP));
        }

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("End")) {
            String[] commandInputArray = commandInput.split(" - ");
            String command = commandInputArray[0];
            String name = commandInputArray[1];

            switch (command) {
                case "CastSpell":
                    int MPNeeded = Integer.parseInt(commandInputArray[2]);
                    String spellName = commandInputArray[3];
                    int HP = heroData.get(name).get(0);
                    int MPBeforeSpell = heroData.get(name).get(1);
                    int MPAfterSpell = 0;

                    if (MPNeeded <= MPBeforeSpell) {
                        MPAfterSpell = MPBeforeSpell - MPNeeded;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, MPAfterSpell);
                        heroData.put(name, Arrays.asList(HP, MPAfterSpell));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandInputArray[2]);
                    String attacker = commandInputArray[3];
                    int currentHP = heroData.get(name).get(0);
                    int currentMP = heroData.get(name).get(1);
                    int HPAfterFight = currentHP - damage;

                    if (HPAfterFight > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, HPAfterFight);
                        heroData.put(name, Arrays.asList(HPAfterFight, currentMP));
                    } else {
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                        heroData.remove(name);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandInputArray[2]);
                    int currentHP1 = heroData.get(name).get(0);
                    int currentMP1 = heroData.get(name).get(1);
                    int newMP = currentMP1 + amount;
                    
                    if (newMP > 200) {
                        System.out.printf("%s recharged for %d MP!%n", name, 200 - currentMP1);
                        heroData.put(name, Arrays.asList(currentHP1, 200));
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", name, amount);
                        heroData.put(name, Arrays.asList(currentHP1, newMP));
                    }
                    break;
                case "Heal":
                    int healAmount = Integer.parseInt(commandInputArray[2]);
                    int currentHP11 = heroData.get(name).get(0);
                    int currentMP11 = heroData.get(name).get(1);
                    int newHP = currentHP11 + healAmount;
                    
                    if (newHP > 100) {
                        System.out.printf("%s healed for %d HP!%n", name, 100 - currentHP11);
                        heroData.put(name, Arrays.asList(100, currentMP11));
                    } else {
                        System.out.printf("%s healed for %d HP!%n", name, healAmount);
                        heroData.put(name, Arrays.asList(newHP, currentMP11));
                    }
                    break;
            }
            
            commandInput = scanner.nextLine();
        }

        heroData.entrySet().stream().sorted((left, right) -> {
            int result = right.getValue().get(0).compareTo(left.getValue().get(0));
            if (result == 0) {
                result = left.getKey().compareTo(right.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

    }
}
