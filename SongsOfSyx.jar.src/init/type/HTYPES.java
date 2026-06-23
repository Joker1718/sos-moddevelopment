/*     */ package init.type;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.RMAPS;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class HTYPES {
/*  14 */   private final ArrayListGrower<HTYPE> all = new ArrayListGrower(); private final HTYPE SUBJECT; private final HTYPE RETIREE; private final HTYPE GUARD; private final HTYPE RECRUIT; private final HTYPE STUDENT; private final HTYPE PRISONER; private final HTYPE TOURIST; private final HTYPE SOLDIER; private final HTYPE ENEMY;
/*     */   
/*     */   HTYPES(HCLASSES cls) {
/*  17 */     D.gInit(this);
/*     */ 
/*     */     
/*  20 */     this.SUBJECT = new HTYPE((LISTE<HTYPE>)this.all, "CITIZEN", 
/*  21 */         HCLASSES.CITIZEN(), 
/*  22 */         D.g("Citizen"), D.g("Citizens"), 
/*  23 */         D.g("CitizenD", "Citizens are the bulk of your population and will carry out your wishes."), 
/*  24 */         (COLOR)new ColorImp(3, 1, 19), 
/*  25 */         (SPRITE)(UI.icons()).s.typeCitizen.createColored((COLOR)new ColorImp(50, 255, 255)));
/*  26 */     this.RETIREE = new HTYPE((LISTE<HTYPE>)this.all, "RETIREE", 
/*  27 */         HCLASSES.CITIZEN(), 
/*  28 */         D.g("Retiree"), D.g("Retirees"), 
/*  29 */         D.g("RetireeD", "Retired people are citizens that have served you for many years and are now entitled to some relaxation their final years. They do not work."), 
/*  30 */         (COLOR)new ColorImp((COLOR)new ColorImp(8, 20, 20)), 
/*  31 */         (SPRITE)(UI.icons()).s.typeRetire.createColored((COLOR)new ColorImp(255, 128, 0)));
/*  32 */     this.GUARD = new HTYPE((LISTE<HTYPE>)this.all, "GUARD", 
/*  33 */         HCLASSES.CITIZEN(), 
/*  34 */         D.g("Guard"), D.g("Guards"), 
/*  35 */         D.g("GuardD", "Guards are soldiers on guard duty. They spend their days guarding your city, catch criminals and make your citizens obedient"), 
/*  36 */         (COLOR)new ColorImp((COLOR)new ColorImp(20, 8, 8)), 
/*  37 */         (SPRITE)(UI.icons()).s.typeGuard.createColored((COLOR)new ColorImp(255, 90, 90)));
/*  38 */     this.RECRUIT = new HTYPE((LISTE<HTYPE>)this.all, "RECRUIT", 
/*  39 */         HCLASSES.CITIZEN(), 
/*  40 */         D.g("Recruit"), D.g("Recruits"), 
/*  41 */         D.g("RecruitD", "Recruits are citizens either training their combat skills for a place in a division, or honing these skills towards the limit you've set for said division."), 
/*  42 */         (COLOR)new ColorImp(20, 8, 16), 
/*  43 */         (SPRITE)(UI.icons()).s.typeRecruit.createColored((COLOR)new ColorImp(50, 255, 128)));
/*  44 */     this.STUDENT = new HTYPE((LISTE<HTYPE>)this.all, "STUDENT", 
/*  45 */         HCLASSES.CITIZEN(), 
/*  46 */         D.g("Student"), D.g("Students"), 
/*  47 */         D.g("StudentD", "Students are citizens currently attending university. They do not count towards your workforce."), 
/*  48 */         (COLOR)new ColorImp(20, 8, 16), 
/*  49 */         (SPRITE)(UI.icons()).s.typeStudent.createColored((COLOR)new ColorImp(50, 128, 255)));
/*  50 */     this.PRISONER = new HTYPE((LISTE<HTYPE>)this.all, "PRISONER", 
/*  51 */         HCLASSES.OTHER(), 
/*  52 */         D.g("Prisoner"), D.g("Prisoners"), 
/*  53 */         D.g("PrisonerD", "Prisoners are caught criminals, or POWs. Prisoners will spend their time in your dungeons. They can be used as sacrifices in temples, or gladiators. They can also be enslaved, or executed."), 
/*  54 */         (COLOR)new ColorImp(20, 20, 8), 
/*  55 */         (SPRITE)(UI.icons()).s.typePrison.createColored((COLOR)new ColorImp(200, 200, 200)));
/*  56 */     this.TOURIST = new HTYPE((LISTE<HTYPE>)this.all, "TOURIST", 
/*  57 */         HCLASSES.OTHER(), 
/*  58 */         Dic.¤¤Tourist, Dic.¤¤Tourists, 
/*  59 */         D.g("TouristD", "Tourists are foreigners visiting your city in search of a spectacle. Treat them well, and they will show their appreciation by tossing you some coins."), 
/*  60 */         (COLOR)new ColorImp(20, 20, 8), 
/*  61 */         (SPRITE)(UI.icons()).s.typeTourist.createColored((COLOR)new ColorImp(128, 128, 255)));
/*  62 */     this.SOLDIER = new HTYPE((LISTE<HTYPE>)this.all, "SOLDIER", 
/*  63 */         HCLASSES.CITIZEN(), 
/*  64 */         D.g("Soldier"), D.g("Soldiers"), 
/*  65 */         D.g("SoldierD", "Soldiers are men on the battlefield."), 
/*  66 */         (COLOR)new ColorImp(3, 1, 19), 
/*  67 */         (SPRITE)(UI.icons()).s.typeSoldier.createColored((COLOR)new ColorImp(50, 128, 255)));
/*  68 */     this.ENEMY = new HTYPE((LISTE<HTYPE>)this.all, "ENEMY", 
/*  69 */         HCLASSES.OTHER(), 
/*  70 */         D.g("Enemy"), D.g("Enemies"), 
/*  71 */         D.g("EnemyD", "Enemies are hostile peoples, bent on destroying your rule"), 
/*  72 */         (COLOR)new ColorImp(30, 1, 1), 
/*  73 */         (SPRITE)(UI.icons()).s.typeSoldier.createColored((COLOR)new ColorImp(255, 50, 50)));
/*     */     
/*  75 */     this.RIOTER = new HTYPE((LISTE<HTYPE>)this.all, "RIOTER", 
/*  76 */         HCLASSES.OTHER(), 
/*  77 */         D.g("Rioter"), D.g("Rioters"), 
/*  78 */         D.g("RioterD", "Rioters are former citizens, who have had enough of your rule and express their disappointment by burning your city to ashes."), 
/*  79 */         (COLOR)new ColorImp(30, 1, 1), 
/*  80 */         (SPRITE)(UI.icons()).s.typeRioter.createColored((COLOR)new ColorImp(255, 50, 50)));
/*  81 */     this.DERANGED = new HTYPE((LISTE<HTYPE>)this.all, "DERANGED", 
/*  82 */         HCLASSES.OTHER(), 
/*  83 */         D.g("Deranged"), D.g("Derangeds", "Deranged"), 
/*  84 */         D.g("DerangedD", "Deranged are people who have gone insane. They will do no work, and wander around your city doing erratic things. Can be cured in an asylum."), 
/*  85 */         (COLOR)new ColorImp(30, 30, 1), 
/*  86 */         (SPRITE)(UI.icons()).s.typeCrazy.createColored((COLOR)new ColorImp(255, 255, 50)));
/*  87 */     this.NOBILITY = new HTYPE((LISTE<HTYPE>)this.all, "NOBILITY", 
/*  88 */         HCLASSES.NOBLE(), 
/*  89 */         D.g("Nobility"), D.g("Nobles"), 
/*  90 */         D.g("NobilityD", "The nobility are above the common plebs. Do not work in a traditional sense and require the best of services."), 
/*  91 */         (COLOR)new ColorImp(20, 8, 20), 
/*  92 */         (SPRITE)(UI.icons()).s.noble.createColored((COLOR)new ColorImp(255, 50, 255)));
/*  93 */     this.SLAVE = new HTYPE((LISTE<HTYPE>)this.all, "SLAVE", 
/*  94 */         HCLASSES.SLAVE(), 
/*  95 */         D.g("Slave"), D.g("Slaves"), 
/*  96 */         D.g("SlaveD", "Slaves do mundane and hard work, but need little in return. They can not be trained into soldiers, or be educated. If you mistreat slaves they may revolt."), 
/*  97 */         (COLOR)new ColorImp(20, 20, 20), 
/*  98 */         (SPRITE)(UI.icons()).s.slave.createColored((COLOR)new ColorImp(200, 200, 200)));
/*     */     
/* 100 */     this.CHILD_SLAVE = new HTYPE((LISTE<HTYPE>)this.all, "CHILD_SLAVE", 
/* 101 */         HCLASSES.OTHER(), 
/* 102 */         D.g("ChildS", "Child (slave)"), D.g("ChildSS", "Children (slave)"), 
/* 103 */         D.g("ChildD", "Children benefit from staffed nurseries to grow up to become subjects. Children can be educated by schools."), 
/* 104 */         (COLOR)new ColorImp(20, 20, 20), 
/* 105 */         (SPRITE)(UI.icons()).s.typeChild.createColored((COLOR)new ColorImp(50, 255, 50)));
/*     */     
/* 107 */     this.CHILD = new HTYPE((LISTE<HTYPE>)this.all, "CHILD", 
/* 108 */         HCLASSES.OTHER(), 
/* 109 */         D.g("Child"), D.g("Children"), 
/* 110 */         D.g("ChildD", "Children benefit from staffed nurseries to grow up to become subjects. Children can be educated by schools."), 
/* 111 */         (COLOR)new ColorImp(20, 20, 20), 
/* 112 */         (SPRITE)(UI.icons()).s.typeChild.createColored((COLOR)new ColorImp(50, 255, 50)));
/*     */     
/* 114 */     this.PARENT = new HTYPE((LISTE<HTYPE>)this.all, "PARENT", 
/* 115 */         HCLASSES.CITIZEN(), 
/* 116 */         D.g("Parent"), D.g("Parents"), 
/* 117 */         D.g("ParentD", "Parents are currently tending to infants and do not work."), 
/* 118 */         (COLOR)new ColorImp(20, 20, 20), 
/* 119 */         (SPRITE)(UI.icons()).s.typeParent.createColored((COLOR)new ColorImp(50, 255, 50)));
/*     */     
/* 121 */     this.PARENT_SLAVE = new HTYPE((LISTE<HTYPE>)this.all, "PARENT_SLAVE", 
/* 122 */         HCLASSES.SLAVE(), 
/* 123 */         D.g("ParentS", "Parent (slave)"), D.g("Parentss", "Parents (slave)"), 
/* 124 */         D.g("ParentSD", "Parents are currently tending to infants and do not work."), 
/* 125 */         (COLOR)new ColorImp(20, 20, 20), 
/* 126 */         (SPRITE)(UI.icons()).s.typeParent.createColored((COLOR)new ColorImp(50, 255, 50)));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     self = this;
/*     */ 
/*     */     
/* 136 */     this.ENEMY.hostile = true;
/* 137 */     this.RIOTER.hostile = true;
/*     */     
/* 139 */     this.SOLDIER.visible = false;
/*     */     
/* 141 */     this.SUBJECT.works = true;
/* 142 */     this.SLAVE.works = true;
/*     */     
/* 144 */     this.PARENT.child = this.CHILD;
/* 145 */     this.PARENT_SLAVE.child = this.CHILD_SLAVE;
/*     */     
/* 147 */     this.CHILD.parent = this.PARENT;
/* 148 */     this.CHILD_SLAVE.parent = this.SLAVE;
/*     */     
/* 150 */     KeyMap<HTYPE> mm = new KeyMap();
/* 151 */     for (HTYPE h : this.all) {
/* 152 */       mm.put(h.key, h);
/*     */     }
/* 154 */     this.map = new RMAPS("HTYPE", (LIST)this.all);
/*     */   }
/*     */   private final HTYPE RIOTER; private final HTYPE DERANGED; private final HTYPE NOBILITY; private final HTYPE SLAVE; private final HTYPE CHILD_SLAVE; private final HTYPE CHILD; private final HTYPE PARENT; private final HTYPE PARENT_SLAVE; private final RMAPS<HTYPE> map; private static HTYPES self;
/*     */   public static RMAPS<HTYPE> MAP() {
/* 158 */     return self.map;
/*     */   }
/*     */   
/*     */   public static LIST<HTYPE> ALL() {
/* 162 */     return (LIST<HTYPE>)self.all;
/*     */   }
/*     */   
/*     */   public static HTYPE SUBJECT() {
/* 166 */     return self.SUBJECT;
/*     */   }
/*     */   
/*     */   public static HTYPE RETIREE() {
/* 170 */     return self.RETIREE;
/*     */   }
/*     */   
/*     */   public static HTYPE RECRUIT() {
/* 174 */     return self.RECRUIT;
/*     */   }
/*     */   
/*     */   public static HTYPE STUDENT() {
/* 178 */     return self.STUDENT;
/*     */   }
/*     */   
/*     */   public static HTYPE PRISONER() {
/* 182 */     return self.PRISONER;
/*     */   }
/*     */   
/*     */   public static HTYPE TOURIST() {
/* 186 */     return self.TOURIST;
/*     */   }
/*     */   
/*     */   public static HTYPE SOLDIER() {
/* 190 */     return self.SOLDIER;
/*     */   }
/*     */   
/*     */   public static HTYPE ENEMY() {
/* 194 */     return self.ENEMY;
/*     */   }
/*     */   
/*     */   public static HTYPE RIOTER() {
/* 198 */     return self.RIOTER;
/*     */   }
/*     */   
/*     */   public static HTYPE DERANGED() {
/* 202 */     return self.DERANGED;
/*     */   }
/*     */   
/*     */   public static HTYPE NOBILITY() {
/* 206 */     return self.NOBILITY;
/*     */   }
/*     */   
/*     */   public static HTYPE SLAVE() {
/* 210 */     return self.SLAVE;
/*     */   }
/*     */   
/*     */   public static HTYPE CHILD() {
/* 214 */     return self.CHILD;
/*     */   }
/*     */   
/*     */   public static HTYPE GUARD() {
/* 218 */     return self.GUARD;
/*     */   }
/*     */ 
/*     */   
/*     */   public static HTYPE CHILD_SLAVE() {
/* 223 */     return self.CHILD_SLAVE;
/*     */   }
/*     */   
/*     */   public static HTYPE PARENT() {
/* 227 */     return self.PARENT;
/*     */   }
/*     */   
/*     */   public static HTYPE PARENT_SLAVE() {
/* 231 */     return self.PARENT_SLAVE;
/*     */   }
/*     */   
/*     */   public static HTYPE child(HCLASS cl) {
/* 235 */     if (cl == HCLASSES.SLAVE()) {
/* 236 */       return CHILD_SLAVE();
/*     */     }
/* 238 */     return CHILD();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\HTYPES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */