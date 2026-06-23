/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Res
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final RESOURCE[] resourceI;
/*     */   private final GETTER<Integer> ier;
/*     */   private final int off;
/*     */   private final GETTER<JanitorInstance> getter;
/*     */   
/*     */   Res(int width, RESOURCE[] resourceI, GETTER<Integer> ier, int off, GETTER<JanitorInstance> getter) {
/* 131 */     super(width, 32);
/* 132 */     this.resourceI = resourceI;
/* 133 */     this.ier = ier;
/* 134 */     this.off = off;
/* 135 */     this.getter = getter;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 140 */     RESOURCE res = this.resourceI[((Integer)this.ier.get()).intValue() * 4 + this.off];
/* 141 */     if (res == null) {
/*     */       return;
/*     */     }
/* 144 */     GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */     
/* 146 */     res.icon().renderCY(r, body().x1() + 8, body().cY());
/*     */     
/* 148 */     Str.TMP.clear();
/* 149 */     Str.TMP.add(((JanitorInstance)this.getter.get()).bits.resAm(res));
/* 150 */     if (((JanitorInstance)this.getter.get()).bits.resMissing(res)) {
/* 151 */       (GCOLOR.T()).IBAD.bind();
/*     */     }
/* 153 */     (UI.FONT()).S.renderCY(r, this.body.x1() + 40, body().cY(), (CharSequence)Str.TMP);
/* 154 */     COLOR.unbind();
/*     */     
/* 156 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 163 */     RESOURCE res = this.resourceI[((Integer)this.ier.get()).intValue() * 4 + this.off];
/* 164 */     if (res == null)
/*     */       return; 
/* 166 */     GBox b = (GBox)text;
/* 167 */     b.title(res.name);
/* 168 */     b.textLL(Gui.¤¤Global);
/* 169 */     b.NL();
/* 170 */     b.add((SPRITE)GFORMAT.f0(b.text(), -SETT.MAINTENANCE().estimateGlobal(res)));
/* 171 */     b.NL();
/*     */     
/* 173 */     b.NL(8);
/*     */     
/* 175 */     if (((JanitorInstance)this.getter.get()).bits.resMissing(res))
/* 176 */       b.add((SPRITE)b.text().warnify().add(Gui.¤¤Bad)); 
/* 177 */     b.NL();
/*     */     
/* 179 */     if ((S.get()).developer) {
/* 180 */       ((JanitorInstance)this.getter.get()).bits.hover(b, res, (RoomInstance)this.getter.get());
/* 181 */       b.NL();
/*     */     } 
/*     */     
/* 184 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\Gui$Res.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */