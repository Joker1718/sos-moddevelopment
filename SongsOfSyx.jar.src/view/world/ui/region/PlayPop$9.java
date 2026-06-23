/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GuiSection
/*     */ {
/* 176 */   String mt = String.valueOf(Dic.¤¤Modifiers) + ": " + String.valueOf(Dic.¤¤Modifiers);
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 180 */     GBox b = (GBox)text;
/* 181 */     b.title(r.pop.name);
/*     */     
/* 183 */     b.textLL(Dic.¤¤Current);
/* 184 */     b.tab(6);
/* 185 */     b.add((SPRITE)GFORMAT.i(b.text(), r.pop.get((Region)g.get())));
/* 186 */     b.NL();
/*     */     
/* 188 */     b.textLL(Dic.¤¤Target);
/* 189 */     b.tab(6);
/* 190 */     b.add((SPRITE)GFORMAT.i(b.text(), r.pop.target((Region)g.get())));
/* 191 */     b.NL();
/*     */     
/* 193 */     b.textLL(Dic.¤¤Growth);
/* 194 */     b.tab(6);
/* 195 */     b.add((SPRITE)GFORMAT.percInc(b.text(), r.pop.growth((Region)g.get())));
/* 196 */     b.NL();
/*     */     
/* 198 */     b.textLL(Dic.¤¤Capacity);
/* 199 */     b.tab(6);
/* 200 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.RACES()).capacity.get((BOOSTABLE_O)g.get())));
/* 201 */     b.NL();
/*     */     
/* 203 */     b.textLL(Dic.¤¤Rarity);
/* 204 */     b.tab(6);
/* 205 */     b.add((SPRITE)GFORMAT.perc(b.text(), r.pop.maxPopulation));
/* 206 */     b.NL();
/*     */ 
/*     */     
/* 209 */     b.sep();
/*     */     
/* 211 */     r.pop.dtarget.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), this.mt, true);
/*     */     
/* 213 */     b.sep();
/*     */     
/* 215 */     r.pop.growth.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), Dic.¤¤Growth, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayPop$9.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */