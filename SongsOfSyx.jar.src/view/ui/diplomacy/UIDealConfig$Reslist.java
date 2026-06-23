/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT_O;
/*     */ import util.gui.common.UIPicker;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Reslist
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final GuiSection pop;
/*     */   
/*     */   Reslist(Deal deal, final DealParty p) {
/* 190 */     super(Dic.¤¤Resource);
/* 191 */     icon((SPRITE)(UI.icons()).s.storage);
/* 192 */     body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/* 193 */     this.pop = (GuiSection)new UIPicker<TRADABLE>(p.resources, 16, TR.ALL())
/*     */       {
/*     */         protected void addToRow(GuiSection row, final GETTER<TRADABLE> g)
/*     */         {
/* 197 */           GuiSection s = new GuiSection()
/*     */             {
/*     */               protected void hoverInfoSelf(GUI_BOX box)
/*     */               {
/* 201 */                 GBox b = (GBox)box;
/* 202 */                 b.title(((TRADABLE)g.get()).name);
/* 203 */                 b.textLL((p.f() == FACTIONS.player()) ? Dic.¤¤buyPrice : Dic.¤¤sellPrice);
/* 204 */                 b.tab(6);
/* 205 */                 b.add((SPRITE)GFORMAT.i(b.text(), ((p.f() == FACTIONS.player()) ? p.npc().buyer((TRADABLE)g.get()).addPrice(1) : p.npc().seller((TRADABLE)g.get()).removePrice(1))));
/* 206 */                 b.NL();
/* 207 */                 b.textLL(Dic.¤¤Tariff);
/* 208 */                 b.tab(6);
/* 209 */                 b.add((SPRITE)GFORMAT.i(b.text(), TradeManager.totalFee((p.f() == FACTIONS.player()) ? p.f() : (Faction)p.npc(), (p.f() == FACTIONS.player()) ? (Faction)p.npc() : p.f(), RD.DIST().distance((Faction)p.npc()), (TRADABLE)g.get(), 1)));
/* 210 */                 b.NL();
/* 211 */                 super.hoverInfoSelf(box);
/*     */               }
/*     */             };
/*     */ 
/*     */           
/* 216 */           s.addRelBody(8, DIR.E, (SPRITE)new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 220 */                   text.add('/');
/* 221 */                   GFORMAT.i(text, p.resources.max(g.get()));
/*     */                 }
/*     */               });
/* 224 */           s.body().incrW(64.0D);
/* 225 */           s.addRelBody(8, DIR.E, (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 229 */                   GFORMAT.i(text, p.valueResource((TRADABLE)g.get(), p.resources.get(g.get())));
/*     */                 }
/* 231 */               }).hh((SPRITE)(UI.icons()).s.money));
/* 232 */           s.addRelBody(128, DIR.E, (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 236 */                   int am = p.resources.get(g.get());
/* 237 */                   if (am == 0)
/* 238 */                     am = 1; 
/* 239 */                   GFORMAT.i(text, (p.valueResource((TRADABLE)g.get(), am) / am));
/* 240 */                   text.s();
/* 241 */                   text.add(UIDealConfig.¤¤item);
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {}
/* 248 */               }).r(DIR.E));
/* 249 */           row.addRelBody(8, DIR.E, (RENDEROBJ)s);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 259 */     (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 264 */     activeSet(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealConfig$Reslist.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */