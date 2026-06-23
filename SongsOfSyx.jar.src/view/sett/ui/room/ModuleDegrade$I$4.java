/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import settlement.environment.Foundation;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.placement.UtilExtraCost;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 163 */     GFORMAT.percInv(text, ((RoomInstance)get.get()).getDegrade());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 169 */     b.title(Dic.¤¤Degrade);
/* 170 */     b.text(Dic.¤¤DegradeDesc);
/* 171 */     b.NL();
/* 172 */     b.textLL(Dic.¤¤Current);
/* 173 */     b.tab(6);
/* 174 */     b.add((SPRITE)GFORMAT.percInv(b.text(), ((RoomInstance)get.get()).getDegrade()));
/*     */     
/* 176 */     if ((S.get()).developer) {
/* 177 */       b.add((SPRITE)GFORMAT.f(b.text(), ((RoomInstance)get.get()).degrader(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mX()).getSecret(), 4));
/*     */     }
/*     */     
/* 180 */     b.NL(4);
/*     */     
/* 182 */     if (!(((RoomInstance)get.get()).constructor().blue()).reqs.passes(FACTIONS.player())) {
/* 183 */       b.error(ModuleDegrade.¤¤Lock);
/* 184 */     } else if (((RoomInstance)get.get()).upgrade() > 0 && !((RoomInstance)get.get()).constructor().blue().upgrades().requires(((RoomInstance)get.get()).upgrade()).passes(FACTIONS.player())) {
/* 185 */       b.error(ModuleDegrade.¤¤Lock);
/*     */     } 
/* 187 */     b.sep();
/* 188 */     b.NL(8);
/*     */     
/* 190 */     RoomInstance ins = (RoomInstance)get.get();
/* 191 */     ROOM_DEGRADER deg = ((RoomInstance)get.get()).degrader(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY());
/* 192 */     int area = ins.area();
/* 193 */     double iso = ins.isolation(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY());
/* 194 */     double boost = SETT.MAINTENANCE().speed();
/*     */     
/* 196 */     double ram = 0.0D;
/* 197 */     for (int i = 0; i < deg.resSize(); i++) {
/* 198 */       ram += deg.resAmount(i);
/*     */     }
/*     */     
/* 201 */     b.textLL(ModuleDegrade.¤¤maintenance);
/* 202 */     b.NL();
/*     */     
/* 204 */     SETT.MAINTENANCE().getClass(); ModuleDegrade.I.this.col(b, Dic.¤¤Base, '*', 0.020833333333333332D * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 205 */     ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤RoomType, '*', deg.base());
/* 206 */     ModuleDegrade.I.this.col(b, Dic.¤¤Area, '*', area);
/* 207 */     if (ModuleDegrade.I.this.blue.constructor().isHeavy()) {
/* 208 */       ModuleDegrade.I.this.col(b, Foundation.¤¤name, '*', 1.0D + UtilExtraCost.foundation((Room)get.get(), ((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY()));
/* 209 */       ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤cost, '*', deg.expenseRate() / (1.0D + UtilExtraCost.foundation((Room)get.get(), ((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY())));
/*     */     }
/* 211 */     else if (ModuleDegrade.I.this.blue.constructor().mustBeIndoors() && ModuleDegrade.I.this.blue.constructor().usesArea()) {
/* 212 */       ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤cost, '*', deg.expenseRate());
/*     */     } 
/* 214 */     ModuleDegrade.I.this.col(b, (SETT.ROOMS()).isolation.info.name, '*', 1.0D + (1.0D - iso) * 2.0D);
/* 215 */     ModuleDegrade.I.this.col(b, Dic.¤¤Boosts, '*', boost);
/*     */     
/* 217 */     double tot = ROOM_DEGRADER.rate(boost, deg.base(), iso, ram, ins.area()) * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 218 */     double resr = ROOM_DEGRADER.rateResource(boost, deg.base(), iso, ram) * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     
/* 220 */     b.tab(6);
/* 221 */     b.add((SPRITE)b.text().add('=').s().add((int)(tot - resr)));
/*     */ 
/*     */ 
/*     */     
/* 225 */     b.sep();
/*     */     
/* 227 */     for (int j = 0; j < deg.resSize(); j++) {
/* 228 */       if (deg.resAmount(j) > 0) {
/*     */         
/* 230 */         RESOURCE res = deg.res(j);
/* 231 */         b.add((SPRITE)res.icon());
/* 232 */         b.textL(res.name);
/* 233 */         b.tab(6);
/* 234 */         b.add((SPRITE)GFORMAT.f0(b.text(), -ROOM_DEGRADER.rateResource(boost, deg.base(), iso, deg.resAmount(j)) * TIME.years().bitConversion((TIMECYCLE)TIME.days())));
/* 235 */         b.NL();
/*     */       } 
/*     */     } 
/* 238 */     b.sep();
/*     */ 
/*     */     
/* 241 */     b.NL(8);
/* 242 */     b.textLL(Dic.¤¤Total);
/* 243 */     b.tab(6);
/* 244 */     b.add((SPRITE)GFORMAT.f(b.text(), tot, 2));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleDegrade$I$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */