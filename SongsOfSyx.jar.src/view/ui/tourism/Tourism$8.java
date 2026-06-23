/*     */ package view.ui.tourism;
/*     */ 
/*     */ import game.tourism.TOURISM;
/*     */ import init.race.Race;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 205 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 209 */     selectedSet(TOURISM.permit(r));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 214 */     TOURISM.permit(r, !TOURISM.permit(r));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 219 */     GBox b = (GBox)text;
/* 220 */     b.title(r.info.names);
/*     */     
/* 222 */     b.textL(Dic.¤¤Occurrence);
/* 223 */     b.tab(5);
/* 224 */     b.add((SPRITE)GFORMAT.perc(b.text(), (r.tourism()).occurence));
/* 225 */     b.NL(2);
/*     */     
/* 227 */     b.textL(Tourism.¤¤Generosity);
/* 228 */     b.tab(5);
/* 229 */     b.add((SPRITE)GFORMAT.perc(b.text(), (r.tourism()).credits));
/* 230 */     b.NL(2);
/*     */ 
/*     */     
/* 233 */     b.textLL(Tourism.¤¤Attractions);
/* 234 */     b.NL();
/* 235 */     boolean line = false;
/* 236 */     for (RoomBlueprintImp p : (r.tourism()).attractions) {
/* 237 */       b.add((SPRITE)p.iconBig());
/* 238 */       b.text(p.info.names);
/*     */       
/* 240 */       if (line) {
/* 241 */         b.NL();
/*     */       } else {
/* 243 */         b.tab(7);
/*     */       } 
/* 245 */       line = !line;
/*     */     } 
/*     */     
/* 248 */     b.NL(8);
/*     */     
/* 250 */     b.textL(Tourism.¤¤Permit);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tourism\Tourism$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */