/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.stocks.ROOM_STOCKS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.text.D;
/*     */ 
/*     */ class Stocked
/*     */   extends AIPLAN.PLANRES {
/*  17 */   private static CharSequence ¤¤verb = "Being stocked"; private final ROOM_STOCKS blue;
/*     */   
/*     */   static {
/*  20 */     D.ts(Stocked.class);
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer walk; private final AIPLAN.PLANRES.Resumer sit;
/*     */   public Stocked() {
/*  24 */     super("prisStocked");
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.blue = (SETT.ROOMS()).STOCKS;
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
/*  41 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  45 */           COORDINATE c = Stocked.this.blue.stockReserve();
/*  46 */           if (c == null)
/*  47 */             return null; 
/*  48 */           d.planTile.set(c);
/*  49 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, c);
/*  50 */           if (s == null) {
/*  51 */             can(a, d);
/*  52 */             return null;
/*     */           } 
/*  54 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  59 */           return Stocked.this.sit.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  64 */           return Stocked.this.blue.stockIsReserved(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  69 */           Stocked.this.blue.stockCancel(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */       };
/*     */     
/*  73 */     this.sit = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  78 */           DIR dir = Stocked.this.blue.stockDir(d.planTile.x(), d.planTile.y(), a.speed.dir());
/*  79 */           a.speed.setDirCurrent(dir);
/*  80 */           Stocked.this.blue.stockUse(d.planTile.x(), d.planTile.y());
/*  81 */           return res(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  87 */           if (TIME.light().nightIs()) {
/*  88 */             can(a, d);
/*  89 */             PrisonerData.self.stocked.setMax(d);
/*  90 */             return null;
/*     */           } 
/*  92 */           return (AI.SUBS()).LAY.activateTime(a, d, 16);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  97 */           return Stocked.this.blue.stockIsReserved(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 102 */           Stocked.this.blue.stockCancel(d.planTile.x(), d.planTile.y());
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s = this.walk.set(a, d);
/*     */     if (s != null)
/*     */       return s; 
/*     */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Stocked.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */