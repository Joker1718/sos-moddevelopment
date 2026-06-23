/*    */ package settlement.path;
/*    */ import game.battle.Army;
/*    */ 
/*    */ public enum AVAILABILITY {
/*    */   public static final int Penalty = 2;
/*    */   public static AVAILABILITY[] ROADS;
/*    */   public final boolean availableToStandOn;
/*  8 */   SOLID(-1.0D, 0.0D, true, 1.0D, false),
/*  9 */   NOT_ACCESSIBLE(-1.0D, 0.0D, false, 0.5D, false),
/* 10 */   NORMAL(1.0D, 0.0D, false, 1.0D, true),
/* 11 */   AVOID_PASS(4.0D, 5.0D, false, 0.5D, false),
/* 12 */   AVOID_LIKE_FUCK(32.0D, 1.0D, false, 0.25D, false),
/*    */   
/* 14 */   ROAD0(0.5D, 0.0D, false, 1.0D, true),
/* 15 */   ROAD1(0.5D, 0.0D, false, 1.05D, true),
/* 16 */   ROAD2(0.5D, 0.0D, false, 1.1D, true),
/* 17 */   ROAD3(0.5D, 0.0D, false, 1.15D, true),
/* 18 */   ROAD4(0.5D, 0.0D, false, 1.2D, true),
/* 19 */   PENALTY2(2.0D, 0.0D, false, 0.8D, true),
/* 20 */   PENALTY3(3.0D, 0.0D, false, 0.5D, true),
/* 21 */   PENALTY4(4.0D, 1.0D, false, 0.5D, true),
/* 22 */   ROOM(1.2D, 0.0D, false, 1.0D, false),
/*    */   
/* 24 */   ROOM_SOLID(-1.0D, 0.0D, true, 1.0D, false),
/*    */   
/* 26 */   ENEMY(0.5D, 0.0D, true, 1.0D, false, -1.0D); public final double from; public final double player;
/*    */   
/*    */   static {
/* 29 */     ROADS = new AVAILABILITY[] {
/* 30 */         ROAD0, 
/* 31 */         ROAD1, 
/* 32 */         ROAD2, 
/* 33 */         ROAD3, 
/* 34 */         ROAD4
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     values = values();
/*    */   }
/*    */   
/*    */   public final double enemy;
/*    */   public final boolean tileCollide;
/*    */   
/*    */   AVAILABILITY(double player, double from, boolean tileCollide, double movementBonus, boolean available, double enemy) {
/* 51 */     this.player = player;
/* 52 */     this.enemy = enemy;
/* 53 */     this.from = from;
/* 54 */     this.tileCollide = tileCollide;
/* 55 */     this.movementSpeed = movementBonus;
/* 56 */     this.movementSpeedI = 1.0D / this.movementSpeed;
/* 57 */     this.availableToStandOn = available;
/*    */   }
/*    */   public final double movementSpeed; public final double movementSpeedI; public static final AVAILABILITY[] values;
/*    */   
/*    */   public boolean isSolid(Army a) {
/* 62 */     if (a == GAME.ARMIES().player())
/* 63 */       return (this.player < 0.0D); 
/* 64 */     return (this.enemy < 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\AVAILABILITY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */