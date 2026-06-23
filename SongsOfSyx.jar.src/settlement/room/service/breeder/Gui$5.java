/*     */ package settlement.room.service.breeder;
/*     */ 
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 164 */     GBox b = (GBox)text;
/* 165 */     b.title(Gui.¤¤limit);
/* 166 */     b.text(Gui.¤¤limitD);
/* 167 */     b.NL(8);
/*     */     
/* 169 */     b.textLL(Gui.¤¤population);
/* 170 */     b.tab(7);
/* 171 */     b.add((SPRITE)GFORMAT.i(b.text(), POP.tot(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).race)));
/* 172 */     b.NL();
/*     */     
/* 174 */     b.textLL(Gui.¤¤incoming);
/* 175 */     b.tab(7);
/* 176 */     b.add((SPRITE)GFORMAT.i(b.text(), (POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).race) - POP.tot(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).race))));
/* 177 */     b.NL();
/*     */     
/* 179 */     b.textLL(Gui.¤¤total);
/* 180 */     b.tab(7);
/* 181 */     b.add((SPRITE)GFORMAT.i(b.text(), POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).race)));
/* 182 */     b.NL();
/*     */     
/* 184 */     b.textLL(Gui.¤¤toBreed);
/* 185 */     b.tab(7);
/* 186 */     b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_BREEDER)Gui.access$2(Gui.this)).limitSpecies - POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.access$2(Gui.this)).race))));
/* 187 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Gui$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */