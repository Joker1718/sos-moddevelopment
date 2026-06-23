/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 161 */     GFORMAT.perc(text, ((ROOM_POLICE)Gui.access$1(Gui.this)).value());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 166 */     b.text(Gui.¤¤value);
/* 167 */     b.NL(4);
/*     */     
/* 169 */     b.textLL(Dic.¤¤Employees);
/* 170 */     b.tab(6);
/* 171 */     GFORMAT.i(b.text(), ((ROOM_POLICE)Gui.access$1(Gui.this)).employment().employed());
/* 172 */     b.NL();
/*     */ 
/*     */     
/* 175 */     b.textLL(Dic.¤¤Population);
/* 176 */     b.NL();
/* 177 */     for (HCLASS_RACE r : HCLASS_RACE.REAL()) {
/* 178 */       if (((ROOM_POLICE)Gui.access$1(Gui.this)).access(r).is()) {
/* 179 */         b.tab(1).add(r.icon);
/* 180 */         b.tab(6);
/* 181 */         GFORMAT.i(b.text(), (STATS.POP()).POP.data(r.cl).get(r.race));
/* 182 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 186 */     b.text(Dic.¤¤Value);
/* 187 */     b.tab(6);
/* 188 */     GFORMAT.perc(b.text(), ((ROOM_POLICE)Gui.access$1(Gui.this)).value());
/* 189 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */