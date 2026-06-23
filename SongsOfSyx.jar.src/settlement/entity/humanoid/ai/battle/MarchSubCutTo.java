/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ final class MarchSubCutTo extends AISUB.Simple {
/*     */   private final AISUB inter;
/*     */   
/*     */   MarchSubCutTo() {
/*  20 */     super("MarchCutTo");
/*     */ 
/*     */     
/*  23 */     this.inter = (AISUB)new AISUB.Simple("MarchCutToInter")
/*     */       {
/*     */         public AISUB.AISubActivation activate(Humanoid a, AIManager d)
/*     */         {
/*  27 */           return activate(a, d, (AI.STATES()).STOP.activate(a, d, 0.0D));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISTATE resume(Humanoid a, AIManager d) {
/*  32 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  37 */           if (e.event == HEvent.COLLISION_TILE) {
/*  38 */             if ((AI.modules()).battle.tile.shouldattackTile(d, a, e.tx, e.ty)) {
/*  39 */               d.interrupt(a, e);
/*  40 */               d.overwrite(a, (AI.modules()).battle.tile.init(d, a, e.tx, e.ty));
/*     */             } else {
/*  42 */               d.interrupt(a, e);
/*  43 */               d.overwrite(a, MarchSubCutTo.this.inter.activate(a, d));
/*     */             } 
/*     */             
/*  46 */             return false;
/*     */           } 
/*     */           
/*  49 */           return InterBattle.listener.event(a, d, e);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  55 */     this.distFar = 9216;
/*  56 */     this.distFarI = 1.0850694444444444E-4D;
/*  57 */     this.distClose = 512;
/*  58 */     this.distCloseI = 0.001953125D;
/*     */   }
/*     */   private static final VectorImp vec = new VectorImp(); private final int distFar = 9216;
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/*  62 */     d.subByte = (byte)(d.subByte + 1);
/*  63 */     Div div = a.division();
/*  64 */     if (div == null) {
/*  65 */       if (d.subByte <= 1)
/*  66 */         return (AI.STATES()).STAND.activate(a, d, 0.05D); 
/*  67 */       return null;
/*     */     } 
/*     */ 
/*     */     
/*  71 */     if (!div.reporter.posHas(a)) {
/*  72 */       if (d.subByte == 1)
/*  73 */         return (AI.STATES()).STAND.activate(a, d, 0.05D); 
/*  74 */       return null;
/*     */     } 
/*  76 */     COORDINATE dest = div.reporter.getPixel(a);
/*     */     
/*  78 */     if (BattleUtil.isInPosition(dest, a, d)) {
/*  79 */       a.speed.magnitudeInit(0.0D);
/*  80 */       if (d.subByte == 1)
/*  81 */         return (AI.STATES()).STAND.activate(a, d, 0.05D); 
/*  82 */       return null;
/*     */     } 
/*     */     
/*  85 */     double speed = div.settings().speed();
/*     */     
/*  87 */     int distX = dest.x() - a.physics.body().cX();
/*  88 */     int distY = dest.y() - a.physics.body().cY();
/*  89 */     double dist = (distX * distX + distY * distY);
/*     */     
/*  91 */     if (dist > 9216.0D) {
/*  92 */       speed += a.speed.magintudeMax() * (dist - 9216.0D) * 1.0850694444444444E-4D;
/*  93 */     } else if (dist < 512.0D) {
/*  94 */       speed *= dist * 0.001953125D;
/*     */     } 
/*     */     
/*  97 */     speed = CLAMP.d(speed, 32.0D, a.speed.magintudeMax());
/*     */     
/*  99 */     AISTATE s = (AI.STATES()).MOVE_TO.move(a, d, dest.x(), dest.y(), 0.05D, speed);
/*     */     
/* 101 */     if (dist < 9216.0D) {
/* 102 */       DIR dir = div.position().dir(a.divSpot());
/* 103 */       if (dir != null) {
/* 104 */         if (div.status().threatAt(dir, div)) {
/* 105 */           a.speed.setDirCurrent(dir);
/* 106 */         } else if (div.status().isFighting()) {
/* 107 */           a.speed.setDirCurrent(div.position().dir());
/*     */         } 
/*     */       } else {
/* 110 */         a.speed.setDirCurrent(div.position().dir());
/*     */       } 
/*     */     } 
/* 113 */     a.speed.setDirCurrent(div.position().dir());
/*     */     
/* 115 */     return s;
/*     */   }
/*     */   private final double distFarI = 1.0850694444444444E-4D; private final int distClose = 512; private final double distCloseI = 0.001953125D;
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 120 */     if (e.event == HEvent.COLLISION_TILE) {
/*     */       
/* 122 */       if ((AI.modules()).battle.tile.shouldattackTile(d, a, e.tx, e.ty)) {
/*     */         
/* 124 */         d.overwrite(a, (AI.modules()).battle.tile.init(d, a, e.tx, e.ty));
/*     */       } else {
/*     */         
/* 127 */         d.interrupt(a, e);
/* 128 */         d.overwrite(a, this.inter.activate(a, d));
/*     */       } 
/* 130 */       return false;
/*     */     } 
/* 132 */     if (e.event == HEvent.MEET_ENEMY)
/*     */     {
/* 134 */       if (a.speed.magnitudeRelative() > 0.4D) {
/*     */         
/* 136 */         Div div = a.division();
/* 137 */         if (div != null)
/*     */         {
/* 139 */           if (div.reporter.posHas(a)) {
/* 140 */             COORDINATE dest = div.reporter.getPixel(a);
/* 141 */             double m = vec.set((RECTANGLE)a.physics.body(), dest.x(), dest.y());
/* 142 */             if (m > 0.0D && vec.nX() * a.speed.nX() + vec.nY() * a.speed.nY() > 0.6D) {
/* 143 */               d.overwrite(a, (AI.STATES()).MOVE_TO.move(a, d, dest.x(), dest.y(), 0.05D, 0.7D * a.speed.magintudeMax()));
/* 144 */               return false;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 152 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSubCutTo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */