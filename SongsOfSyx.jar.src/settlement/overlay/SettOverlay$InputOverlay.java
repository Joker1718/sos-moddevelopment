/*     */ package settlement.overlay;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.path.components.SComp0Level;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class InputOverlay
/*     */   extends Addable
/*     */ {
/*     */   private RoomInstance ins;
/* 225 */   private double max = 36.0D;
/*     */   
/* 227 */   private final Rec bounds = new Rec();
/*     */   
/*     */   public InputOverlay() {
/* 230 */     super(true, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {
/* 235 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 236 */     f.init(this);
/*     */     
/* 238 */     double speed = 0.0D;
/* 239 */     double speedCount = 0.0D;
/*     */     
/* 241 */     ENTITY[] es = SETT.ENTITIES().getAllEnts();
/*     */     
/* 243 */     for (int i = 0; i < SETT.ENTITIES().Imax(); i++) {
/* 244 */       ENTITY e = es[i];
/* 245 */       if (e != null && e instanceof Humanoid) {
/* 246 */         Humanoid a = (Humanoid)e;
/* 247 */         if ((STATS.WORK()).EMPLOYED.get(a) == this.ins) {
/* 248 */           speed += (BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)a.indu());
/* 249 */           speedCount++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     if (speedCount == 0.0D) {
/* 255 */       speed = (BOOSTABLES.PHYSICS()).SPEED.baseValue;
/*     */     } else {
/* 257 */       speed /= speedCount;
/*     */     } 
/*     */     
/* 260 */     this.max = 36.0D * speed / (BOOSTABLES.PHYSICS()).SPEED.baseValue;
/* 261 */     for (COORDINATE c : this.ins.body()) {
/* 262 */       if (this.ins.is(c)) {
/* 263 */         f.pushSmaller(c, 0.0D);
/*     */       }
/*     */     } 
/* 266 */     SComp0Level cc = (SETT.PATH()).comps.zero;
/* 267 */     this.bounds.set(VIEW.s().getWindow().tiles());
/* 268 */     this.bounds.pad(cc.size(), cc.size());
/* 269 */     for (COORDINATE c : this.bounds) {
/* 270 */       if (SETT.IN_BOUNDS(c)) {
/* 271 */         f.setValue2(c, -1.0D);
/*     */       }
/*     */     } 
/* 274 */     while (f.hasMore()) {
/* 275 */       PathTile t = GUTIL.flooder().pollSmallest();
/*     */       
/* 277 */       if (t.getValue() >= this.max) {
/* 278 */         f.reopen(t);
/* 279 */         f.pushSloppy((COORDINATE)t, t.getValue());
/*     */         break;
/*     */       } 
/* 282 */       t.setValue2(t.getValue() / this.max);
/*     */       
/* 284 */       for (DIR d : DIR.ALL) {
/* 285 */         if ((SETT.PATH()).coster.player.getCost(t.x(), t.y(), t.x() + d.x(), t.y() + d.y()) >= 0.0D) {
/* 286 */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance() / ((AVAILABILITY)(SETT.PATH()).availability.get((COORDINATE)t, d)).movementSpeed);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 292 */     while (f.hasMore()) {
/*     */       
/* 294 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 295 */       SComponent c = (SComponent)cc.get((COORDINATE)t);
/* 296 */       if (c == null) {
/*     */         continue;
/*     */       }
/* 299 */       if (t.getValue() >= AIModule_Work.MAX_FETCH_DISTANCE) {
/* 300 */         int x1 = c.centreX() & (cc.size() - 1 ^ 0xFFFFFFFF);
/* 301 */         int y1 = c.centreY() & (cc.size() - 1 ^ 0xFFFFFFFF);
/* 302 */         f.setValue2(x1, y1, -2.0D);
/*     */       } 
/*     */       
/* 305 */       SComponentEdge e = c.edgefirst();
/* 306 */       while (e != null) {
/* 307 */         f.pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance());
/* 308 */         e = e.next();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 313 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 319 */     double v = GUTIL.flooder().getValue2(it.coo());
/*     */     
/* 321 */     if (v == -1.0D) {
/* 322 */       SComp0Level cc = (SETT.PATH()).comps.zero;
/* 323 */       SComponent c = (SComponent)cc.get(it.coo());
/* 324 */       if (c != null) {
/* 325 */         int x1 = c.centreX() & (cc.size() - 1 ^ 0xFFFFFFFF);
/* 326 */         int y1 = c.centreY() & (cc.size() - 1 ^ 0xFFFFFFFF);
/* 327 */         if (GUTIL.flooder().getValue2(x1, y1) == -2.0F) {
/* 328 */           v = -2.0D;
/*     */         }
/*     */       } 
/*     */     } 
/* 332 */     if (v == -2.0D) {
/* 333 */       renderUnder(0.0D, r, it, false);
/* 334 */     } else if (v == -1.0D) {
/* 335 */       renderUnder(0.2D, r, it, false);
/*     */     } else {
/* 337 */       v = 1.0D - v;
/* 338 */       v += 0.5D;
/* 339 */       v = CLAMP.d(v, 0.0D, 1.0D);
/* 340 */       renderUnder(v, r, it, false);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void finishBelow() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\SettOverlay$InputOverlay.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */