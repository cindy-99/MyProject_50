FlowerManagementSystem_50

#项目概述
花卉信息管理系统是一个基于Java开发的简单控制台应用程序，用于管理花卉的基本信息。本项目按照软件工程标准流程开发，包含完整的分支管理和文档体系。

#项目结构
FlowerManagementSystem_50/
├── src/
│   └── FlowerManagementSystem.java
├── docs/
│   ├── 需求分析.md
│   ├── 设计文档.md
│   └── 用户手册.md
├── LICENSE
├── README.md
└── CONTRIBUTING.md
#许可证
本项目采用 MIT 许可证, MIT许可证允许用户自由使用、复制、修改、合并、发布、分发、再许可和销售软件副本，是开源项目中最常用的许可证之一。

#分支管理策略
##分支结构
main: 主分支，存放稳定版本代码
develop: 开发分支，集成各个功能
feature/*: 功能分支，开发新功能
hotfix/*: 热修复分支，紧急修复bug
##分支操作记录
###创建开发分支
git checkout -b develop
### 开发新功能
git checkout -b feature/add-flower-crud
###开发完成后合并到develop
git checkout develop
git merge feature/add-flower-crud
###修复bug
git checkout -b hotfix/fix-search-bug
###修复完成后合并到develop和main
git checkout develop
git merge hotfix/fix-search-bug
git checkout main
git merge hotfix/fix-search-bug
##解决冲突示例
// 冲突示例：两个分支都修改了同一行代码
<<<<<<< HEAD
private ArrayList<Flower> flowerList = new ArrayList<>();
=======
private List<Flower> flowerList = new ArrayList<>();
>>>>>>> feature/refactor-code
解决方案：选择更优的实现方式，保留接口编程原则。

#使用说明
##环境要求
JDK 8+
Git
##安装运行
git clone https://github.com/your-username/FlowerManagementSystem_XX.git
cd FlowerManagementSystem_XX
javac src/FlowerManagementSystem.java
java src/FlowerManagementSystem

#开发者
GitHub: cindy
Email: cindy3927826@qq.com


