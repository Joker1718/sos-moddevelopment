/*     */ package settlement.room.service.breeder;
/*     */ 
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
/*     */ class null
/*     */   extends GuiSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  99 */     GBox b = (GBox)text;
/* 100 */     b.title(Gui.¤¤limitGlobal);
/* 101 */     b.text(Gui.¤¤limitGlobalD);
/* 102 */     b.NL(8);
/*     */     
/* 104 */     b.textLL(Gui.¤¤population);
/* 105 */     b.tab(7);
/* 106 */     b.add((SPRITE)GFORMAT.i(b.text(), POP.tot()));
/* 107 */     b.NL();
/*     */     
/* 109 */     b.textLL(Gui.¤¤incoming);
/* 110 */     b.tab(7);
/* 111 */     b.add((SPRITE)GFORMAT.i(b.text(), (POP.next() - POP.tot())));
/* 112 */     b.NL();
/*     */     
/* 114 */     b.textLL(Gui.¤¤total);
/* 115 */     b.tab(7);
/* 116 */     b.add((SPRITE)GFORMAT.i(b.text(), POP.next()));
/* 117 */     b.NL();
/*     */     
/* 119 */     b.textLL(Gui.¤¤toBreed);
/* 120 */     b.tab(7);
/* 121 */     b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_BREEDER)Gui.access$2(Gui.this)).limitTotal - POP.next())));
/* 122 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Gui$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */