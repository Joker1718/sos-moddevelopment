/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GMeter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Meter
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   private final STAT s;
/*     */   private final HCLASS cl;
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   Meter(STAT s, HCLASS cl, GETTER<Race> race) {
/* 111 */     this.s = s;
/* 112 */     body().setDim(200.0D, 16.0D);
/* 113 */     this.cl = cl;
/* 114 */     this.race = race;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 119 */     double now = this.s.standing().get(this.cl, (Race)this.race.get());
/* 120 */     double max = this.s.standing().max(this.cl, (Race)this.race.get());
/* 121 */     double prev = this.s.standing().getPrev(this.cl, (Race)this.race.get(), 8);
/* 122 */     int w = (int)(200.0D * Math.sqrt(this.s.standing().normalized(this.cl, (Race)this.race.get())));
/* 123 */     if (w > 0)
/* 124 */       GMeter.renderDelta(r, prev / max, now / max, body().x1(), body().x1() + w, body().y1(), body().y2()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\StatRow$Meter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */