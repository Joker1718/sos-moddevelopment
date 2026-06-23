/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ class null
/*     */   extends SubFight.ResumerB
/*     */ {
/*     */   null(SubFight paramSubFight2) {}
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  61 */     switch (e.type) {
/*     */       case IMPACT_DAMAGE:
/*  63 */         return 0.0D;
/*     */     } 
/*  65 */     return super.poll(a, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  71 */     switch (e.event) {
/*     */       
/*     */       case COLLISION_SOFT:
/*  74 */         if (d.otherEntity() != null) {
/*  75 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/*  76 */         } else if (e.other != null) {
/*  77 */           a.speed.setDirCurrent(DIR.get(a.body(), e.other.body()));
/*  78 */         }  return false;
/*     */       case COLLISION_TILE:
/*  80 */         if (d.otherEntity() != null) {
/*  81 */           a.speed.setDirCurrent(DIR.get(a.body(), d.otherEntity().body()));
/*     */         } else {
/*  83 */           a.speed.setDirCurrent(DIR.get(-e.norX, -e.norY));
/*  84 */         }  return false;
/*     */       case MEET_ENEMY:
/*  86 */         d.otherEntitySet((Humanoid)e.other);
/*  87 */         a.speed.setDirCurrent(DIR.get(-e.norX, -e.norY));
/*  88 */         return false;
/*     */     } 
/*  90 */     return super.event(a, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/*  97 */     if (a.speed.isZero())
/*  98 */       return SubFight.this.findFooting.set(a, d); 
/*  99 */     return (AI.STATES()).anima.sword_out.activate(a, d, 1.0D + RND.rFloat0(0.5D));
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 104 */     if (!a.speed.isZero())
/* 105 */       return (AI.STATES()).STOP.activate(a, d); 
/* 106 */     return SubFight.this.findFooting.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\SubFight$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */