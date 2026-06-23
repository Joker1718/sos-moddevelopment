/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Emiss
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER.GETTER_IMP<Region> g;
/*     */   
/*     */   Emiss(final GETTER.GETTER_IMP<Region> g) {
/* 148 */     this.g = g;
/*     */     
/* 150 */     add((SPRITE)(UI.icons()).m.flag, 0, 0);
/*     */     
/* 152 */     int wi = 150;
/*     */     
/* 154 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(wi, 18)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 158 */           GMeter.render(r, GMeter.C_REDGREEN, (RD.OWNER()).affiliation.getD(g.get()), (RECTANGLE)body());
/*     */         }
/*     */       };
/*     */     
/* 162 */     addRightC(16, (RENDEROBJ)renderImp);
/*     */     
/* 164 */     INT.INTE ii = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 168 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 173 */           return (FACTIONS.player()).emissaries.assimilate.max(g.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 178 */           return (FACTIONS.player()).emissaries.assimilate.get(g.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 183 */           (FACTIONS.player()).emissaries.assimilate.set(g.get(), t);
/*     */         }
/*     */       };
/*     */     
/* 187 */     GSliderInt sl = new GSliderInt(ii, wi / 2, true);
/*     */     
/* 189 */     addRightC(16, (RENDEROBJ)sl);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 197 */     GBox b = (GBox)text;
/* 198 */     b.title(((RD.OWNER()).affiliation.info()).name);
/* 199 */     b.text(((RD.OWNER()).affiliation.info()).desc);
/* 200 */     b.NL(8);
/* 201 */     b.textLL(Other.¤¤eCurrent);
/* 202 */     b.tab(7);
/* 203 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).emissaries.assimilate.get(this.g.get())));
/* 204 */     b.NL();
/* 205 */     b.textLL(Other.¤¤eAvailable);
/* 206 */     b.tab(7);
/* 207 */     b.add((SPRITE)GFORMAT.i(b.text(), (FACTIONS.player()).emissaries.available()));
/* 208 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\Other$Emiss.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */