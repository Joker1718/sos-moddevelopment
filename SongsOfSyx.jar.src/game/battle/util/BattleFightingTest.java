/*     */ package game.battle.util;
/*     */ 
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BattleFightingTest
/*     */ {
/*  13 */   private static double CHANCE = 100.0D;
/*  14 */   private static double CHANCE_MIN = 1.0D / CHANCE;
/*  15 */   private static double CHANCE_SPAN = CHANCE - CHANCE_MIN;
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  19 */     RND.rInt();
/*     */     
/*  21 */     Attack a = new Attack();
/*  22 */     Defence d = new Defence();
/*     */     
/*  24 */     a.offence = 1.0D;
/*  25 */     a.aim = 5.0D;
/*  26 */     a.damage = 1.0D;
/*     */     
/*  28 */     d.defence = 1.0D;
/*  29 */     d.parry = 1.0D;
/*  30 */     d.armour = 1.0D;
/*     */     
/*  32 */     d.armourDir = 1.0D;
/*     */     
/*  34 */     perform("normal", a, d);
/*     */     
/*  36 */     test();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void perform(String name, Attack a, Defence d) {
/*  42 */     System.out.println(name);
/*  43 */     a.print();
/*  44 */     d.print();
/*     */     
/*  46 */     Count c = new Count();
/*  47 */     double amount = 1000000.0D;
/*     */     
/*  49 */     for (int i = 0; i < amount; i++) {
/*     */       
/*  51 */       double hit = a.offence / d.defence * (CHANCE_MIN + RND.rFloat() * CHANCE_SPAN);
/*     */       
/*  53 */       if (hit > RND.rFloat()) {
/*  54 */         c.hits++;
/*  55 */         double damage = a.damage;
/*  56 */         double block = a.aim / d.parry * (CHANCE_MIN + RND.rFloat() * CHANCE_SPAN);
/*     */         
/*  58 */         if (block > RND.rFloat()) {
/*  59 */           c.bypass++;
/*     */         } else {
/*  61 */           damage /= d.armourDir;
/*     */         } 
/*     */         
/*  64 */         double r = damage / d.armour * (CHANCE_MIN + RND.rFloat() * CHANCE_SPAN);
/*     */         
/*  66 */         if (r > RND.rFloat()) {
/*  67 */           c.impacts++;
/*  68 */           c.damage += r;
/*  69 */           if (r > 1.0D) {
/*  70 */             c.deaths++;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     c.print(amount);
/*     */     
/*  78 */     average(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static double getDamage(Attack a, Defence d) {
/*  84 */     double hit = averageOver1(a.offence, d.defence, CHANCE_MIN, CHANCE_SPAN);
/*     */     
/*  86 */     hit = CLAMP.d(hit, 0.0D, 1.0D);
/*     */     
/*  88 */     double unblocked = averageOver1(a.aim, d.parry, CHANCE_MIN, CHANCE_SPAN);
/*  89 */     unblocked = CLAMP.d(unblocked, 0.0D, 1.0D);
/*     */     
/*  91 */     double damageBlocked = unblocked * hit * averageAddative(a.damage, d.armour, CHANCE_MIN, CHANCE_SPAN);
/*  92 */     double damageUnblocked = (1.0D - unblocked) * hit * averageAddative(a.damage / d.armourDir, d.armour, CHANCE_MIN, CHANCE_SPAN);
/*     */     
/*  94 */     double damage = damageBlocked + damageUnblocked;
/*  95 */     return damage;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void average(Attack a, Defence d) {
/* 101 */     Count c = new Count();
/*     */     
/* 103 */     double hit = averageOver1(a.offence, d.defence, CHANCE_MIN, CHANCE_SPAN);
/*     */     
/* 105 */     hit = CLAMP.d(hit, 0.0D, 1.0D);
/* 106 */     c.hits += hit * 1000.0D;
/*     */     
/* 108 */     double unblocked = averageOver1(a.aim, d.parry, CHANCE_MIN, CHANCE_SPAN);
/* 109 */     unblocked = CLAMP.d(unblocked, 0.0D, 1.0D);
/* 110 */     c.bypass += hit * 1000.0D * unblocked;
/*     */     
/* 112 */     double damageBlocked = unblocked * hit * averageAddative(a.damage, d.armour, CHANCE_MIN, CHANCE_SPAN);
/* 113 */     double damageUnblocked = (1.0D - unblocked) * hit * averageAddative(a.damage / d.armourDir, d.armour, CHANCE_MIN, CHANCE_SPAN);
/*     */     
/* 115 */     double damage = damageBlocked + damageUnblocked;
/*     */     
/* 117 */     c.damage += 1000.0D * damage;
/*     */     
/* 119 */     c.print(1000.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private static double averageAddative(double A, double B, double DAMAGE_MIN, double DAMAGE_SPAN) {
/* 124 */     double C = A / B;
/* 125 */     double m = DAMAGE_MIN;
/* 126 */     double s = DAMAGE_SPAN;
/* 127 */     double h = m + s;
/*     */     
/* 129 */     if (C <= m)
/* 130 */       return C * C / s * m * h; 
/* 131 */     if (C >= h) {
/* 132 */       return C * Math.log(h / m) / s;
/*     */     }
/* 134 */     return (C * Math.log(C / m) + C - C * C / h) / s;
/*     */   }
/*     */ 
/*     */   
/*     */   private static double averageOver1(double A, double B, double DAMAGE_MIN, double DAMAGE_SPAN) {
/* 139 */     double C = A / B;
/* 140 */     double m = DAMAGE_MIN;
/* 141 */     double s = DAMAGE_SPAN;
/* 142 */     double h = m + s;
/* 143 */     return (C <= m) ? (C * Math.log(h / m) / s) : ((C >= h) ? 1.0D : ((C - m + C * Math.log(h / C)) / s));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void test() {
/* 148 */     double amount = 1000000.0D;
/*     */     
/* 150 */     double DAMAGE_MIN = 0.01D;
/* 151 */     double DAMAGE_SPAN = 100.0D - DAMAGE_MIN;
/*     */     
/* 153 */     double A = 1.0D;
/* 154 */     double B = 1.0D;
/*     */     
/* 156 */     double totA = 0.0D;
/* 157 */     for (int i = 0; i < amount; i++) {
/* 158 */       double hit = A / (B + 1.0D) * (DAMAGE_MIN + RND.rFloat() * DAMAGE_SPAN);
/* 159 */       if (hit > RND.rFloat()) totA++; 
/*     */     } 
/* 161 */     System.out.println("A (sim): " + totA / amount);
/* 162 */     System.out.println("A (ana): " + averageOver1(A, B + 1.0D, DAMAGE_MIN, DAMAGE_SPAN));
/*     */     
/* 164 */     double totB = 0.0D;
/* 165 */     for (int j = 0; j < amount; j++) {
/* 166 */       double hit = A / B * (DAMAGE_MIN + RND.rFloat() * DAMAGE_SPAN);
/* 167 */       if (hit > RND.rFloat())
/* 168 */         totB += hit; 
/*     */     } 
/* 170 */     System.out.println("B (sim): " + totB / amount);
/* 171 */     System.out.println("B (ana): " + averageAddative(A, B, DAMAGE_MIN, DAMAGE_SPAN));
/*     */   }
/*     */ 
/*     */   
/*     */   static class Attack
/*     */   {
/* 177 */     public double offence = 1.0D;
/* 178 */     public double aim = 5.0D;
/* 179 */     public double damage = 1.0D;
/*     */     
/*     */     public void print() {
/* 182 */       System.out.println("attacker");
/* 183 */       System.out.println("  offence   " + this.offence);
/* 184 */       System.out.println("  aim   " + this.aim);
/* 185 */       System.out.println("  damage  " + this.damage);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class Defence
/*     */   {
/* 192 */     public double defence = 1.0D;
/* 193 */     public double parry = 1.0D;
/* 194 */     public double armourDir = 1.0D;
/* 195 */     public double armour = 1.0D;
/*     */     
/*     */     public void print() {
/* 198 */       System.out.println("defender");
/* 199 */       System.out.println("  defence   " + this.defence);
/* 200 */       System.out.println("  parry   " + this.parry);
/* 201 */       System.out.println("  shield  " + this.armourDir);
/* 202 */       System.out.println("  armour  " + this.armour);
/*     */     } }
/*     */   
/*     */   private static class Count { public double hits;
/*     */     public double bypass;
/*     */     
/*     */     private Count() {
/* 209 */       this.hits = 0.0D;
/* 210 */       this.bypass = 0.0D;
/* 211 */       this.impacts = 0.0D;
/* 212 */       this.deaths = 0.0D;
/* 213 */       this.damage = 0.0D;
/*     */     }
/*     */     public double impacts; public double deaths; public double damage;
/*     */     public void print(double amount) {
/* 217 */       System.out.println("result");
/* 218 */       System.out.println("  Hitrate  " + (int)(1000.0D * this.hits / amount) / 10.0D + "%");
/* 219 */       System.out.println("  Bypass   " + (int)(1000.0D * this.bypass / this.hits) / 10.0D + "%");
/* 220 */       System.out.println("  impacts   " + (int)(1000.0D * this.impacts / this.hits) / 10.0D + "%");
/* 221 */       System.out.println("     damage   " + (int)(1000.0D * this.damage / this.hits) / 10.0D + "%");
/* 222 */       System.out.println("     deaths   " + (int)(1000.0D * this.deaths / this.hits) / 10.0D + "%");
/*     */       
/* 224 */       System.out.println("  tot damage   " + (int)(10000.0D * this.damage / amount) / 100.0D + "%");
/* 225 */       System.out.println("  tot deaths   " + (int)(10000.0D * this.deaths / amount) / 100.0D + "%");
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\BattleFightingTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */