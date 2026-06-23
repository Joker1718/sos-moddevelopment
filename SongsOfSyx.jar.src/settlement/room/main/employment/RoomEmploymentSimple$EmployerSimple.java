/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
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
/*     */ public class EmployerSimple
/*     */ {
/*     */   private final RoomEmploymentSimple si;
/*     */   
/*     */   public EmployerSimple(RoomEmploymentSimple si) {
/* 248 */     this.si = si;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean employ(Humanoid h) {
/* 253 */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/* 254 */     if (ins != null && ins.blueprintI() == this.si.blueprint()) {
/* 255 */       if (ins.blueprintI() == this.si.blueprint())
/* 256 */       { if (ins.employees().isOverstaffed()) {
/* 257 */           (STATS.WORK()).EMPLOYED.set(h, null);
/* 258 */           ins = null;
/*     */         } else {
/* 260 */           return true;
/*     */         }  }
/* 262 */       else { (STATS.WORK()).EMPLOYED.set(h, null); }
/*     */     
/*     */     }
/*     */     
/* 266 */     if (this.si.neededWorkers() > this.si.employed()) {
/* 267 */       if (this.si.blueprint().instancesSize() <= 0)
/* 268 */         throw new RuntimeException((this.si.blueprint()).key + " " + (this.si.blueprint()).key + " " + this.si.neededWorkers()); 
/* 269 */       int i = RND.rInt(this.si.blueprint().instancesSize()); int k;
/* 270 */       for (k = 0; k < this.si.blueprint().instancesSize(); k++) {
/* 271 */         RoomInstance in = this.si.blueprint().getInstance((i + k) % this.si.blueprint().instancesSize());
/* 272 */         if (in.active() && in.employees().employed() < in.employees().target()) {
/* 273 */           (STATS.WORK()).EMPLOYED.set(h, in);
/* 274 */           return true;
/*     */         } 
/*     */       } 
/* 277 */       LOG.err("no! " + this.si.neededWorkers() + " " + this.si.employed() + " " + this.si.blueprint().instancesSize());
/* 278 */       for (k = 0; k < this.si.blueprint().instancesSize(); k++) {
/* 279 */         RoomInstance in = this.si.blueprint().getInstance((i + k) % this.si.blueprint().instancesSize());
/* 280 */         LOG.err("" + k + " " + k + " " + in.active() + " " + in.employees().employed() + " " + in.employees().target() + " " + in.employees().hardTarget() + " " + this.si.getFill());
/*     */       } 
/*     */     } 
/*     */     
/* 284 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int employable() {
/* 289 */     return this.si.neededWorkers() - this.si.employed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmploymentSimple$EmployerSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */