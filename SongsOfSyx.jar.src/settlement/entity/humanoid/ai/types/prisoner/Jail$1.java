/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES) {
/*  47 */     super(paramPLANRES);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  51 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  58 */     if (d.planByte1 <= 0) {
/*  59 */       return null;
/*     */     }
/*  61 */     d.planByte1 = (byte)(d.planByte1 - 1);
/*     */     
/*  63 */     if (!Jail.this.b.isWithin(d.planTile.x(), d.planTile.y(), a.tc())) {
/*  64 */       return Jail.this.walkToDoor.set(a, d);
/*     */     }
/*     */     
/*  67 */     if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0) {
/*  68 */       AISUB.AISubActivation s = Jail.this.eat.set(a, d);
/*  69 */       if (s != null) {
/*  70 */         return s;
/*     */       }
/*     */     } 
/*  73 */     if (TIME.light().nightIs()) {
/*  74 */       AISUB.AISubActivation s = Jail.this.sleep.set(a, d);
/*  75 */       if (s != null) {
/*  76 */         return s;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  82 */     if (RND.oneIn(5))
/*     */     {
/*  84 */       if (RND.oneIn(8)) {
/*  85 */         AISUB.AISubActivation s = Jail.this.poop.set(a, d);
/*  86 */         if (s != null)
/*  87 */           return s; 
/*     */       } else {
/*  89 */         AISUB.AISubActivation s = Jail.this.changeSpot.set(a, d);
/*  90 */         if (s != null) {
/*  91 */           return s;
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  97 */     return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Jail$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */