import java.util.ArrayList;
import java.util.Scanner;

// 花卉类
class Flower {
    private String name;
    private String color;
    private String bloomingSeason;
    private double price;

    public Flower(String name, String color, String bloomingSeason, double price) {
        this.name = name;
        this.color = color;
        this.bloomingSeason = bloomingSeason;  // ✅ 修正：传入正确的参数
        this.price = price;
    }

    // getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }

    public void setBloomingSeason(String bloomingSeason) {
        this.bloomingSeason = bloomingSeason;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-10s %-15s ¥%.2f", name, color, bloomingSeason, price);
    }
}

// 花卉管理系统类
public class FlowerManagementSystem_50 {
    private ArrayList<Flower> flowerList;
    private Scanner scanner;

    public FlowerManagementSystem_50() {
        flowerList = new ArrayList<>();
        scanner = new Scanner(System.in);
        // 添加一些示例数据
        initializeSampleData();
    }

    // 初始化示例数据
    private void initializeSampleData() {
        flowerList.add(new Flower("玫瑰", "红色", "春季", 25.0));
        flowerList.add(new Flower("百合", "白色", "夏季", 30.0));
        flowerList.add(new Flower("向日葵", "黄色", "夏季", 15.0));
        flowerList.add(new Flower("郁金香", "粉色", "春季", 20.0));
    }

    // 显示菜单
    public void displayMenu() {
        System.out.println("\n===== 花卉信息管理系统 =====");
        System.out.println("1. 添加花卉");
        System.out.println("2. 显示所有花卉");
        System.out.println("3. 搜索花卉");
        System.out.println("4. 删除花卉");
        System.out.println("5. 退出系统");
        System.out.print("请选择操作 (1-5): ");
    }

    // 添加花卉
    public void addFlower() {
        System.out.println("\n----- 添加花卉 -----");
        System.out.print("请输入花卉名称: ");
        String name = scanner.next();

        System.out.print("请输入花卉颜色: ");
        String color = scanner.next();

        System.out.print("请输入开花季节: ");
        String season = scanner.next();

        System.out.print("请输入价格: ");
        double price = scanner.nextDouble();

        Flower flower = new Flower(name, color, season, price);
        flowerList.add(flower);

        System.out.println("花卉添加成功!");
    }

    // 显示所有花卉
    public void displayAllFlowers() {
        System.out.println("\n----- 所有花卉信息 -----");
        if (flowerList.isEmpty()) {
            System.out.println("暂无花卉信息!");
            return;
        }

        System.out.printf("%-15s %-10s %-15s %s\n", "名称", "颜色", "开花季节", "价格");
        System.out.println("------------------------------------------------");
        for (Flower flower : flowerList) {
            System.out.println(flower);
        }
    }

    // 搜索花卉
    public void searchFlower() {
        System.out.println("\n----- 搜索花卉 -----");
        System.out.print("请输入要搜索的花卉名称: ");
        String name = scanner.next();

        boolean found = false;
        for (Flower flower : flowerList) {
            if (flower.getName().equalsIgnoreCase(name)) {
                if (!found) {
                    System.out.printf("%-15s %-10s %-15s %s\n", "名称", "颜色", "开花季节", "价格");
                    System.out.println("------------------------------------------------");
                    found = true;
                }
                System.out.println(flower);
            }
        }

        if (!found) {
            System.out.println("未找到名为 \"" + name + "\" 的花卉!");
        }
    }

    // 删除花卉
    public void deleteFlower() {
        System.out.println("\n----- 删除花卉 -----");
        System.out.print("请输入要删除的花卉名称: ");
        String name = scanner.next();

        boolean found = false;
        for (int i = 0; i < flowerList.size(); i++) {
            if (flowerList.get(i).getName().equalsIgnoreCase(name)) {
                flowerList.remove(i);
                System.out.println("花卉 \"" + name + "\" 已删除!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("未找到名为 \"" + name + "\" 的花卉!");
        }
    }

    // 运行系统
    public void run() {
        System.out.println("欢迎使用花卉信息管理系统!");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addFlower();
                    break;
                case 2:
                    displayAllFlowers();
                    break;
                case 3:
                    searchFlower();
                    break;
                case 4:
                    deleteFlower();
                    break;
                case 5:
                    System.out.println("感谢使用花卉信息管理系统，再见!");
                    scanner.close();  // ✅ 建议添加：关闭Scanner
                    return;
                default:
                    System.out.println("无效选择，请重新输入!");
            }
        }
    }

    public static void main(String[] args) {
        FlowerManagementSystem_50 system = new FlowerManagementSystem_50();
        system.run();
    }
}