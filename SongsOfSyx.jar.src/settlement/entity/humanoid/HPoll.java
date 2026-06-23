/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public enum HPoll
/*     */ {
/*  11 */   DEFENCE_SKILL,
/*  12 */   PARRY_SKILL,
/*  13 */   WILL_COLLIDE_WITH,
/*  14 */   COLLIDES,
/*  15 */   SCARE_ANIMAL_NOT,
/*  16 */   BATTLE_READY,
/*  17 */   IMPACT_DAMAGE,
/*  18 */   WORKING,
/*  19 */   IS_ENEMY,
/*  20 */   IS_SLAVE_READY_FOR_UPRISING,
/*  21 */   CAN_INTERRACT;
/*     */   
/*     */   static {
/*  24 */     all = (LIST<HPoll>)new ArrayList((Object[])values());
/*     */     
/*  26 */     poll = new HPollData();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final LIST<HPoll> all;
/*     */   
/*     */   private static HPollData poll;
/*     */ 
/*     */   
/*     */   public static final class HPollData
/*     */   {
/*     */     public HPoll type;
/*     */     public double adx;
/*     */     public double ady;
/*     */     public double facingDot;
/*     */     public ENTITY other;
/*     */     public ECollision colli;
/*     */     public ECollision damage;
/*     */     public boolean isEnemy;
/*     */   }
/*     */   
/*     */   public static final class Handler
/*     */   {
/*     */     public static boolean scaresAnimal(Humanoid a) {
/*  50 */       HPoll.poll.type = HPoll.SCARE_ANIMAL_NOT;
/*  51 */       return (a.ai.poll(a, HPoll.poll) == 0.0D);
/*     */     }
/*     */     
/*     */     public static void collideDamage(Humanoid a, AIManager ai, ECollision coll, ECollision damage) {
/*  55 */       boolean isEnemy = isEnemy(a, coll.other);
/*  56 */       HPoll.poll.type = HPoll.IMPACT_DAMAGE;
/*  57 */       HPoll.poll.colli = coll;
/*  58 */       HPoll.poll.damage = damage;
/*  59 */       HPoll.poll.isEnemy = isEnemy;
/*     */       
/*  61 */       a.ai.poll(a, HPoll.poll);
/*     */     }
/*     */     
/*     */     static boolean collides(Humanoid a, AIManager ai, ENTITY o) {
/*  65 */       HPoll.poll.other = o;
/*  66 */       HPoll.poll.type = HPoll.COLLIDES;
/*     */       
/*  68 */       return (ai.poll(a, HPoll.poll) == 1.0D);
/*     */     }
/*     */     
/*     */     static boolean willCollideWith(Humanoid a, AIManager ai, ENTITY other) {
/*  72 */       HPoll.poll.type = HPoll.WILL_COLLIDE_WITH;
/*  73 */       HPoll.poll.other = other;
/*     */       
/*  75 */       return (ai.poll(a, HPoll.poll) == 1.0D);
/*     */     }
/*     */     
/*     */     public static double defenseSkill(Humanoid a, double faceDot, double adx, double ady) {
/*  79 */       HPoll.poll.facingDot = faceDot;
/*  80 */       HPoll.poll.adx = adx;
/*  81 */       HPoll.poll.ady = ady;
/*  82 */       HPoll.poll.type = HPoll.DEFENCE_SKILL;
/*  83 */       return a.ai.poll(a, HPoll.poll);
/*     */     }
/*     */     
/*     */     public static double parrySkill(Humanoid a, double dot, double adx, double ady) {
/*  87 */       HPoll.poll.facingDot = dot;
/*  88 */       HPoll.poll.adx = adx;
/*  89 */       HPoll.poll.ady = ady;
/*  90 */       HPoll.poll.type = HPoll.PARRY_SKILL;
/*  91 */       return a.ai.poll(a, HPoll.poll);
/*     */     }
/*     */     
/*     */     public static boolean works(Humanoid a) {
/*  95 */       HPoll.poll.type = HPoll.WORKING;
/*  96 */       return (a.ai.poll(a, HPoll.poll) == 1.0D);
/*     */     }
/*     */     
/*     */     public static int isSlaveReadyForUprising(Humanoid a) {
/* 100 */       HPoll.poll.type = HPoll.IS_SLAVE_READY_FOR_UPRISING;
/* 101 */       return (int)a.ai.poll(a, HPoll.poll);
/*     */     }
/*     */     
/*     */     public static boolean isEnemy(Humanoid a, ENTITY other) {
/* 105 */       HPoll.poll.type = HPoll.IS_ENEMY;
/* 106 */       HPoll.poll.other = other;
/* 107 */       return (a.ai.poll(a, HPoll.poll) == 1.0D);
/*     */     }
/*     */     
/*     */     public static boolean canInterract(Humanoid a, ENTITY other) {
/* 111 */       HPoll.poll.type = HPoll.CAN_INTERRACT;
/* 112 */       HPoll.poll.other = other;
/* 113 */       return (a.ai.poll(a, HPoll.poll) == 1.0D);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\HPoll.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */