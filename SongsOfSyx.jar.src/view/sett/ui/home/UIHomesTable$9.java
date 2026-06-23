/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
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
/*     */ class null
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 200 */     GuiSection s = new GuiSection();
/*     */     
/* 202 */     GStat a = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/* 207 */           HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 208 */           furnishing.format(text, h);
/*     */         }
/*     */       };
/*     */     
/* 212 */     GButt.Glow glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.cog)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 216 */           HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/*     */           
/* 218 */           if (h.type == HCLASSES.CITIZEN()) {
/* 219 */             (VIEW.s()).ui.standing.openAccess(h.race);
/*     */           }
/*     */           
/* 222 */           super.clickA();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 228 */           HGROUP h = (HGROUP)HGROUP.all().get(((Integer)ier.get()).intValue());
/* 229 */           if (h.type != HCLASSES.NOBLE())
/* 230 */             text.text(UIHomesTable.¤¤FurnishClick); 
/* 231 */           text.NL(8);
/*     */           
/* 233 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 238 */     s.add((RENDEROBJ)glow);
/* 239 */     s.addRightC(2, (RENDEROBJ)a.r());
/*     */     
/* 241 */     return (RENDEROBJ)s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesTable$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */