/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.spirit.grave.GraveInfo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/* 138 */   private final GText text = new GText((UI.FONT()).M, 32);
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 142 */     GraveInfo info = (ModuleGrave.I.null.access$0(ModuleGrave.I.null.this)).g.info((Room)get.get(), ((Integer)ier.get()).intValue());
/* 143 */     if (info != null) {
/* 144 */       int x1 = body().x1();
/*     */ 
/*     */       
/* 147 */       this.text.setMaxWidth(340);
/* 148 */       this.text.setMultipleLines(false);
/* 149 */       this.text.lablify().clear().set(info.name());
/* 150 */       this.text.renderCY(r, x1 + 8, body().cY());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 162 */     GraveInfo info = (ModuleGrave.I.null.access$0(ModuleGrave.I.null.this)).g.info((Room)get.get(), ((Integer)ier.get()).intValue());
/* 163 */     if (info != null) {
/* 164 */       GBox b = (GBox)text;
/* 165 */       b.title(info.name());
/*     */       
/* 167 */       b.text((info.race()).info.namePosessive);
/* 168 */       b.text((info.type()).name);
/* 169 */       b.NL();
/*     */       
/* 171 */       b.textL(Dic.¤¤Age);
/* 172 */       b.tab(6);
/* 173 */       b.add((SPRITE)GFORMAT.i(b.text(), info.years()));
/* 174 */       b.NL();
/*     */       
/* 176 */       b.NL(8);
/* 177 */       b.textL((info.cause()).name);
/* 178 */       b.NL();
/* 179 */       b.add((SPRITE)b.text().add('(').add((info.cause()).desc).add(')'));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleGrave$I$7$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */