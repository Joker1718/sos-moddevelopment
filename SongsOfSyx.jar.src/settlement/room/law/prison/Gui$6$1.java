/*     */ package settlement.room.law.prison;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CRIMES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 220 */     int k = ((Integer)ier.get()).intValue();
/* 221 */     if (k >= (Gui.null.access$0(Gui.null.this)).list.size())
/*     */       return; 
/* 223 */     Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k);
/* 224 */     h.hover((GBox)text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 231 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/* 232 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -2);
/*     */     
/* 234 */     int k = ((Integer)ier.get()).intValue();
/* 235 */     if (k >= (Gui.null.access$0(Gui.null.this)).list.size())
/*     */       return; 
/* 237 */     Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k);
/* 238 */     int x1 = body().x1();
/* 239 */     STATS.APPEARANCE().portraitRender(r, h.indu(), body().x1(), body().y1(), 1);
/*     */     
/* 241 */     Str t = Str.TMP;
/*     */     
/* 243 */     t.clear();
/* 244 */     t.add(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(h.indu())).name);
/* 245 */     (GCOLOR.T()).H1.bind();
/* 246 */     (UI.FONT()).M.render(r, (CharSequence)t, x1 + 50, body().y1() + 8);
/*     */     
/* 248 */     t.clear();
/* 249 */     t.add((AIModule_Prisoner.punishment(h, h.ai())).action);
/* 250 */     (GCOLOR.T()).H2.bind();
/* 251 */     (UI.FONT()).S.render(r, (CharSequence)t, x1 + 50, body().y1() + 32);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 257 */     int k = ((Integer)ier.get()).intValue();
/* 258 */     if (k >= (Gui.null.access$0(Gui.null.this)).list.size())
/*     */       return; 
/* 260 */     Humanoid h = (Humanoid)(Gui.null.access$0(Gui.null.this)).list.get(k);
/* 261 */     h.click();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Gui$6$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */