/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
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
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 130 */     GFORMAT.iofk(text, ((ExportInstance)g.get()).amount, (((ExportInstance)g.get()).crates * 500));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 135 */     b.textLL(Dic.¤¤Inbound);
/* 136 */     b.add((SPRITE)GFORMAT.i(b.text(), ((ExportInstance)g.get()).spaceReserved));
/* 137 */     b.NL();
/* 138 */     b.textLL(Dic.¤¤Outbound);
/* 139 */     b.add((SPRITE)GFORMAT.i(b.text(), ((ExportInstance)g.get()).amountReserved));
/*     */     
/* 141 */     b.sep();
/* 142 */     if (((ExportInstance)g.get()).resource() != null) {
/*     */       
/* 144 */       b.textLL(Dic.¤¤Total);
/* 145 */       b.NL(8);
/*     */       
/* 147 */       b.textLL(Dic.¤¤Stored);
/* 148 */       b.tab(6);
/* 149 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_EXPORT)Gui.access$2(Gui.this)).tally.amount.get(((ExportInstance)g.get()).resource())));
/* 150 */       b.NL();
/* 151 */       b.textLL(Dic.¤¤Capacity);
/* 152 */       b.tab(6);
/* 153 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_EXPORT)Gui.access$2(Gui.this)).tally.capacity.get(((ExportInstance)g.get()).resource())));
/* 154 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */