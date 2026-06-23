/*     */ package settlement.thing;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GoreHolder
/*     */   extends THINGS.ThingFactory<ThingsGore.Gore>
/*     */ {
/*     */   private final ThingsGore.Gore[] gore;
/*     */   private final boolean slow;
/* 142 */   private double t = 10.0D;
/*     */   
/*     */   GoreHolder(LISTE<THINGS.ThingFactory<?>> all, ThingsGore.Gore[] gore, boolean slow) {
/* 145 */     super(all, gore.length);
/* 146 */     this.gore = gore;
/* 147 */     this.slow = slow;
/*     */   }
/*     */   
/*     */   public void make(ENTITY e, COLOR col) {
/* 151 */     make(
/* 152 */         e.body().cX() + RND.rInt0(32), 
/* 153 */         e.body().cY() + RND.rInt0(32), 
/* 154 */         e.speed.x(), e.speed.y(), col);
/*     */   }
/*     */   
/*     */   public void make(int cx, int cy, double sx, double sy, COLOR col) {
/* 158 */     ThingsGore.Gore f = nextInLine();
/* 159 */     f.init(cx, cy, sx, sy, col);
/* 160 */     f.add();
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 165 */     if (this.slow) {
/* 166 */       this.t -= ds;
/* 167 */       if (this.t > 0.0D)
/*     */         return; 
/* 169 */       this.t = 10.0D;
/* 170 */       ds = 10.0D;
/*     */     } 
/*     */ 
/*     */     
/* 174 */     ThingsGore.Gore g = first();
/* 175 */     ThingsGore.Gore drop = null;
/* 176 */     while (g != null) {
/*     */       
/* 178 */       if (drop == null) {
/* 179 */         drop = g;
/* 180 */       } else if (drop == g) {
/*     */         break;
/*     */       } 
/* 183 */       ThingsGore.Gore next = next(g);
/*     */       
/* 185 */       if (!g.update(ds)) {
/* 186 */         g.remove();
/*     */       }
/* 188 */       g = next;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ThingsGore.Gore[] all() {
/* 194 */     return this.gore;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsGore$GoreHolder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */