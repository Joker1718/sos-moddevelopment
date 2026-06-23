/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.SettMarks;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GTarget;
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
/*     */ class Panel
/*     */   extends GuiSection
/*     */ {
/*     */   GInput name;
/*     */   private SettMarks.SettMark data;
/*     */   
/*     */   void init(SettMarks.SettMark data) {
/* 219 */     this.data = data;
/* 220 */     this.name.text().clear().add((CharSequence)data.name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Panel() {
/* 226 */     this.name = new GInput(new StringInputSprite(20, (UI.FONT()).M)
/*     */         {
/*     */           protected void change()
/*     */           {
/* 230 */             UIMiniHotSpots.Panel.this.data.name.clear().add((CharSequence)text());
/*     */           }
/*     */         });
/* 233 */     add((RENDEROBJ)this.name, 0, 0);
/*     */     
/* 235 */     addRightC(20, (RENDEROBJ)new GButt.Panel((SPRITE)(SPRITES.icons()).m.trash)
/*     */         {
/*     */           protected void clickA() {
/* 238 */             UIMiniHotSpots.Panel.this.data.remove();
/* 239 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */         });
/*     */     
/* 243 */     addRelBody(8, DIR.S, (RENDEROBJ)new GColorPicker(false)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 247 */             return UIMiniHotSpots.Panel.this.data.color;
/*     */           }
/*     */         });
/*     */     
/* 251 */     INT.INTE order = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 255 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 260 */           int i = 0;
/* 261 */           for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 262 */             if (d.active)
/* 263 */               i++; 
/*     */           } 
/* 265 */           return i - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 270 */           int i = 0;
/* 271 */           for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 272 */             if (d == UIMiniHotSpots.Panel.this.data)
/* 273 */               return i; 
/* 274 */             if (d.active)
/* 275 */               i++; 
/*     */           } 
/* 277 */           return -1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 282 */           UIMiniHotSpots.Panel.this.data.setPosition(t);
/* 283 */           for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 284 */             if (t == 0 && d.active) {
/* 285 */               UIMiniHotSpots.Panel.this.init(d);
/*     */               break;
/*     */             } 
/* 288 */             if (d.active) {
/* 289 */               t--;
/*     */             }
/*     */           } 
/*     */         }
/*     */       };
/* 294 */     GTarget t = new GTarget(40, false, true, order);
/*     */     
/* 296 */     addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).H2, UIMiniHotSpots.¤¤order)).toUpper().lablify());
/* 297 */     addRelBody(2, DIR.S, (RENDEROBJ)t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniHotSpots$Panel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */