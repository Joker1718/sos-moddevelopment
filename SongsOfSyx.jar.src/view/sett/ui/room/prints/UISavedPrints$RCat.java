/*     */ package view.sett.ui.room.prints;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RCat
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   Entry e;
/*     */   
/*     */   public RCat() {
/* 181 */     super(380, 40);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 186 */     isActive = (!this.e.isLocked && this.e.cat.entries > 0);
/* 187 */     Cat c = this.e.cat;
/* 188 */     isSelected = c.expanded;
/* 189 */     isHovered = hoveredIs();
/*     */     
/* 191 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/*     */     
/* 193 */     for (int bi = 0; bi < this.e.cat.prints.size() && bi < 6; bi++) {
/* 194 */       ((RoomBlueprintImp)this.e.cat.prints.get(bi)).iconBig().renderCY(r, this.body.x1() + 8 + bi * 24, this.body.cY());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     (UI.FONT()).S.renderCY(r, this.body.x2() - 32 - 48, this.body.cY(), (CharSequence)Str.TMP.clear().add(this.e.cat.entries));
/*     */     
/* 203 */     if (this.e.cat.expanded) {
/* 204 */       (UI.icons()).s.chevron(DIR.S).renderCY(r, this.body.x2() - 32, this.body.cY());
/*     */     } else {
/* 206 */       (UI.icons()).s.chevron(DIR.E).renderCY(r, this.body.x2() - 32, this.body.cY());
/*     */     } 
/* 208 */     if (this.e.cat.entries == 0) {
/* 209 */       OPACITY.O50.bind();
/* 210 */       COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 211 */       OPACITY.unbind();
/*     */     } 
/*     */     
/* 214 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 219 */     if (this.e.cat.entries > 0) {
/* 220 */       this.e.cat.expanded = !this.e.cat.expanded;
/*     */     }
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 225 */     GBox b = (GBox)text;
/* 226 */     for (RoomBlueprintImp p : this.e.cat.prints) {
/* 227 */       b.add((SPRITE)p.iconBig());
/* 228 */       b.textLL(p.info.names);
/* 229 */       b.NL();
/*     */     } 
/* 231 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\UISavedPrints$RCat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */