/*     */ package view.ui.log;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.log.LogEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Entry
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GETTER<Integer> ier;
/* 121 */   private static final Str tmp = new Str(128);
/*     */   
/*     */   Entry(GETTER<Integer> ier) {
/* 124 */     super(450, (UI.FONT()).M.height() * 2 + 30 + 16);
/* 125 */     this.ier = ier;
/*     */   }
/*     */   
/*     */   private LogEntry e() {
/* 129 */     if (((Integer)this.ier.get()).intValue() >= WORLD.LOG().all().size())
/* 130 */       return null; 
/* 131 */     return (LogEntry)WORLD.LOG().all().get(WORLD.LOG().all().size() - 1 - ((Integer)this.ier.get()).intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 136 */     LogEntry e = e();
/* 137 */     if (e == null) {
/*     */       return;
/*     */     }
/* 140 */     if (isHovered) {
/* 141 */       COLOR.WHITE15.render(r, (RECTANGLE)this.body);
/*     */     }
/*     */     
/* 144 */     int x1 = this.body.x1() + 16;
/* 145 */     int cy = this.body.y1() + 20;
/*     */     
/* 147 */     e.icon().renderCY(r, x1, cy);
/*     */     
/* 149 */     if (e.bannerA() != null) {
/* 150 */       (e.bannerA()).MEDIUM.renderCY(r, x1 + 24, cy);
/*     */     }
/* 152 */     if (e.bannerB() != null) {
/* 153 */       (e.bannerB()).MEDIUM.renderCY(r, x1 + 50, cy);
/*     */     }
/*     */     
/* 156 */     tmp.clear();
/* 157 */     DicTime.setDateShort(tmp, e.daySinceStart() * TIME.secondsPerDay());
/*     */     
/* 159 */     (GCOLOR.T()).H1.bind();
/* 160 */     (UI.FONT()).H2.render(r, (CharSequence)tmp, x1 + 76, cy - (UI.FONT()).H2.height() / 2);
/* 161 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     x1 = this.body.x1();
/* 169 */     int y1 = this.body.y1() + 32;
/* 170 */     (UI.FONT()).M.renderIn(r, x1, y1, DIR.NW, (CharSequence)e.message, this.body.width(), this.body.y2() - y1 - 8, 1.0D);
/*     */ 
/*     */     
/* 173 */     GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 179 */     LogEntry e = e();
/* 180 */     if (e == null)
/*     */       return; 
/* 182 */     VIEW.world().activate();
/* 183 */     (VIEW.world()).window.centererTile.set(e.tx(), e.ty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 188 */     LogEntry e = e();
/* 189 */     if (e == null)
/*     */       return; 
/* 191 */     text.text((CharSequence)e.message);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\log\UILog$Entry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */