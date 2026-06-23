/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.settings.S;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.BSection
/*     */ {
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 223 */     GBox b = (GBox)text;
/* 224 */     text.title((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE);
/*     */     
/* 226 */     RoomInstance i = (RoomInstance)get.get();
/* 227 */     if (i.upgrade() == ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/* 228 */       text.text((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_MAX_REACHED);
/*     */       
/*     */       return;
/*     */     } 
/* 232 */     if (ModuleUpgradable.I.this.blueprint.upgrades().desc(ModuleUpgradable.I.this.g(get).upgrade() + 1) != null) {
/* 233 */       b.text(ModuleUpgradable.I.this.blueprint.upgrades().desc(ModuleUpgradable.I.this.g(get).upgrade() + 1));
/* 234 */     } else if (i instanceof settlement.room.service.module.ROOM_SERVICER) {
/* 235 */       b.textLL(Dic.¤¤Quality);
/* 236 */       double d = 1.0D / (i.blueprintI().upgrades().max() + 1.0D);
/* 237 */       b.add((SPRITE)GFORMAT.percInc(b.text(), d));
/* 238 */     } else if (ModuleUpgradable.I.this.blueprint.bonus() != null) {
/* 239 */       b.textLL((ModuleUpgradable.I.this.blueprint.bonus()).name);
/* 240 */       b.add((SPRITE)GFORMAT.f0(b.text(), ModuleUpgradable.I.this.blueprint.upgrades().boost(ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.blueprint.upgrades().boost(ModuleUpgradable.I.this.g(get).upgrade())));
/*     */     } 
/*     */     
/* 243 */     b.NL(8);
/*     */     
/* 245 */     ModuleUpgradable.I.this.g(get).blueprintI().upgrades().requires(ModuleUpgradable.I.this.g(get).upgrade() + 1).hover(text, FACTIONS.player());
/*     */     
/* 247 */     b.NL(8);
/*     */     
/* 249 */     for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 250 */       int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 251 */       if (am > 0) {
/* 252 */         b.add((SPRITE)ModuleUpgradable.I.this.blueprint.constructor().resource(ri).icon());
/* 253 */         GText t = b.text();
/* 254 */         GFORMAT.iIncr(t, -am);
/* 255 */         if (am > ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri))) {
/* 256 */           t.errorify();
/*     */         } else {
/* 258 */           t.normalify();
/* 259 */         }  b.add((SPRITE)t);
/*     */         
/* 261 */         t = b.text();
/* 262 */         t.add('(');
/* 263 */         GFORMAT.i(t, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri)));
/* 264 */         t.add(')');
/* 265 */         b.add((SPRITE)t);
/* 266 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 274 */     if (ModuleUpgradable.I.this.g(get).upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/*     */       return;
/*     */     }
/* 277 */     for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 278 */       int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 279 */       if (am > 0) {
/* 280 */         ModuleUpgradable.I.this.blueprint.constructor().resource(ri).remove(am, FResources.RTYPE.CONSTRUCTION);
/*     */       }
/*     */     } 
/*     */     
/* 284 */     ModuleUpgradable.I.this.g(get).upgradeSet(ModuleUpgradable.I.this.g(get).upgrade() + 1);
/* 285 */     super.clickA();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 290 */     activeSet(true);
/*     */     
/* 292 */     if (ModuleUpgradable.I.this.g(get).upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/* 293 */       activeSet(false);
/*     */       return;
/*     */     } 
/* 296 */     if ((S.get()).developer)
/*     */       return; 
/* 298 */     if (!ModuleUpgradable.I.this.g(get).blueprintI().upgrades().requires(ModuleUpgradable.I.this.g(get).upgrade() + 1).passes(FACTIONS.player())) {
/* 299 */       activeSet(false);
/*     */     }
/*     */     
/* 302 */     for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 303 */       int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 304 */       if (am > ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri))) {
/* 305 */         activeSet(false);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleUpgradable$I$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */