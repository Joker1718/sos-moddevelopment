/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HSprite;
/*     */ import settlement.entity.humanoid.spirte.HSprites;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WALK
/*     */ {
/*     */   private final double target;
/*     */   private final AISTATE state;
/*     */   
/*     */   public WALK(String key, double target) {
/*  89 */     this(key, target, HSprites.MOVE);
/*     */   }
/*     */   
/*     */   public WALK(String key, double target, final HSprite sprite) {
/*  93 */     this.target = target;
/*  94 */     this.state = new AISTATE(key, "walking")
/*     */       {
/*     */         public HSprite sprite(Humanoid a)
/*     */         {
/*  98 */           return sprite;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean update(Humanoid a, AIManager d, double ds) {
/* 103 */           a.speed.magnitudeAdjust(ds, 1.0D, 1.0D);
/*     */           
/* 105 */           d.stateTimer = (float)(d.stateTimer - ds);
/* 106 */           return (d.stateTimer > 0.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE activate(Humanoid a, AIManager d, double time) {
/* 114 */     d.stateTimer = (float)time;
/* 115 */     a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 116 */     return this.state;
/*     */   }
/*     */   
/*     */   AISTATE activate(Humanoid a, AIManager d, float time, float x, float y) {
/* 120 */     a.speed.turn2(x, y).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 121 */     return activate(a, d, time);
/*     */   }
/*     */   
/*     */   public AISTATE activate(Humanoid a, AIManager d, float time, ENTITY other) {
/* 125 */     a.speed.turn2(a.body(), other.body()).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 126 */     return activate(a, d, time);
/*     */   }
/*     */   
/*     */   public AISTATE activateFRom(Humanoid a, AIManager d, float time, ENTITY other) {
/* 130 */     a.speed.turn2(other.body(), a.body()).magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 131 */     return activate(a, d, time);
/*     */   }
/*     */   
/*     */   AISTATE activate(Humanoid a, AIManager d, float time, double deg) {
/* 135 */     a.speed.turnWithAngel(deg);
/* 136 */     a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 137 */     return activate(a, d, time);
/*     */   }
/*     */   
/*     */   AISTATE activateRND(Humanoid a, AIManager d, float time) {
/* 141 */     a.speed.turnRandom();
/* 142 */     a.speed.magnitudeTargetSet(this.target + RND.rFloat(0.1D));
/* 143 */     return activate(a, d, time);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AISTATES$WALK.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */