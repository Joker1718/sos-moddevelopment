/*     */ package view.sett.ui.food;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.food.canteen.ROOM_CANTEEN;
/*     */ import settlement.room.service.food.eatery.ROOM_EATERY;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 167 */     int a = 0;
/* 168 */     for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/* 169 */       ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/* 170 */       a += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*     */     } 
/*     */     int ri;
/* 173 */     for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 174 */       ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 175 */       a = (int)(a + e.totalFood());
/*     */     } 
/*     */     
/* 178 */     for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 179 */       ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 180 */       a = (int)(a + e.totalFood());
/*     */     } 
/*     */     
/* 183 */     GFORMAT.f0(text, a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 191 */     int a = 0;
/* 192 */     for (int ei = 0; ei < RESOURCES.EDI().all().size(); ei++) {
/* 193 */       ResG r = (ResG)RESOURCES.EDI().all().get(ei);
/* 194 */       a += (SETT.ROOMS()).STOCKPILE.tally().amountTotal(r.resource);
/*     */     } 
/*     */     
/* 197 */     b.add((SETT.ROOMS()).STOCKPILE.icon.small);
/* 198 */     b.textL((SETT.ROOMS()).STOCKPILE.info.names);
/* 199 */     b.tab(7);
/* 200 */     b.add((SPRITE)GFORMAT.i(b.text(), a));
/* 201 */     b.NL();
/*     */     int ri;
/* 203 */     for (ri = 0; ri < (SETT.ROOMS()).EATERIES.size(); ri++) {
/* 204 */       ROOM_EATERY e = (ROOM_EATERY)(SETT.ROOMS()).EATERIES.get(ri);
/* 205 */       int am = (int)e.totalFood();
/* 206 */       a += am;
/*     */ 
/*     */       
/* 209 */       b.add(e.icon.small);
/* 210 */       b.textL(e.info.names);
/* 211 */       b.tab(7);
/* 212 */       b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 213 */       b.NL();
/*     */     } 
/*     */     
/* 216 */     for (ri = 0; ri < (SETT.ROOMS()).CANTEENS.size(); ri++) {
/* 217 */       ROOM_CANTEEN e = (ROOM_CANTEEN)(SETT.ROOMS()).CANTEENS.get(ri);
/* 218 */       int am = (int)e.totalFood();
/* 219 */       a += am;
/*     */ 
/*     */       
/* 222 */       b.add(e.icon.small);
/* 223 */       b.textL(e.info.names);
/* 224 */       b.tab(7);
/* 225 */       b.add((SPRITE)GFORMAT.i(b.text(), am));
/* 226 */       b.NL();
/*     */     } 
/*     */     
/* 229 */     b.NL(8);
/*     */     
/* 231 */     b.textLL(Dic.¤¤Total);
/* 232 */     b.tab(7);
/*     */     
/* 234 */     b.add((SPRITE)GFORMAT.i(b.text(), a));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */