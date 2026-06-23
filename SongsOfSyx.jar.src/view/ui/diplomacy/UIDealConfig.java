/*     */ package view.ui.diplomacy;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealBool;
/*     */ import game.faction.diplomacy.deal.DealParty;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.LinkedList;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT_O;
/*     */ import util.gui.common.UIPicker;
/*     */ import util.gui.common.UIPickerRegion;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class UIDealConfig extends GuiSection {
/*  39 */   private static CharSequence ¤¤offer = "¤Offer";
/*  40 */   private static CharSequence ¤¤demand = "¤Demand";
/*  41 */   private static CharSequence ¤¤item = "¤/Item";
/*     */   static {
/*  43 */     D.ts(UIDealConfig.class);
/*     */   }
/*     */   
/*  46 */   private static int BW = 345;
/*  47 */   private static int BH = 34;
/*     */ 
/*     */   
/*     */   public UIDealConfig(Deal deal, int height) {
/*  51 */     LinkedList<RENDEROBJ> rows = new LinkedList<>();
/*     */ 
/*     */     
/*  54 */     for (DealBool b : deal.bools.all()) {
/*  55 */       rows.add(new Bool(b));
/*     */     }
/*  57 */     rows.add(h(¤¤offer));
/*  58 */     rows.add(new Regionlist(deal, deal.player, deal.npc));
/*  59 */     rows.add(new Reslist(deal, deal.player));
/*  60 */     rows.add(new Sum(deal.player));
/*     */     
/*  62 */     rows.add(h(¤¤demand));
/*  63 */     rows.add(new Regionlist(deal, deal.npc, deal.npc));
/*  64 */     rows.add(new Reslist(deal, deal.npc));
/*  65 */     rows.add(new Sum(deal.npc));
/*     */     
/*  67 */     add((RENDEROBJ)(new GScrollRows(rows, height)).view());
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ h(final CharSequence t) {
/*  72 */     return (RENDEROBJ)new RENDEROBJ.RenderImp(BW, BH)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  76 */           (GCOLOR.T()).H1.bind();
/*  77 */           (UI.FONT()).H2.renderCX(r, this.body.cX(), body().y2() - (UI.FONT()).H2.height() - 4, t);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static class Bool
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final DealBool bool;
/*     */     
/*     */     public Bool(DealBool bool) {
/*  88 */       super(bool.info.name);
/*  89 */       this.bool = bool;
/*  90 */       icon(bool.icon);
/*  91 */       body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  97 */       isActive = (this.bool.problem() == null);
/*  98 */       isSelected = this.bool.is();
/*  99 */       super.render(r, ds, isActive, isSelected, isHovered);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 104 */       if (this.bool.problem() == null)
/* 105 */         this.bool.toggle(); 
/* 106 */       super.clickA();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 111 */       GBox b = (GBox)text;
/* 112 */       this.bool.hover(b);
/*     */       
/* 114 */       CharSequence p = this.bool.problem();
/* 115 */       if (p != null) {
/* 116 */         b.error(p);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Regionlist
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final GuiSection pop;
/*     */     private final DealParty p;
/*     */     
/*     */     Regionlist(Deal deal, final DealParty p, DealParty ff) {
/* 129 */       super(Dic.¤¤Regions);
/* 130 */       this.p = p;
/* 131 */       icon((SPRITE)(UI.icons()).s.world);
/* 132 */       body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/* 133 */       GETTER<Faction> gg = new GETTER<Faction>()
/*     */         {
/*     */           public Faction get()
/*     */           {
/* 137 */             return p.f();
/*     */           }
/*     */         };
/*     */       
/* 141 */       this.pop = (GuiSection)new UIPickerRegion(gg, 400)
/*     */         {
/*     */           protected void toggle(Region reg)
/*     */           {
/* 145 */             p.regs.select(reg, !p.regs.selected(reg));
/*     */           }
/*     */ 
/*     */           
/*     */           protected boolean active(Region reg) {
/* 150 */             return p.regs.selecteCan(reg);
/*     */           }
/*     */ 
/*     */           
/*     */           protected boolean selected(Region reg) {
/* 155 */             return p.regs.selected(reg);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void hoverInfo(GBox b, Region reg) {
/* 161 */             b.add((SPRITE)(UI.icons()).s.money);
/* 162 */             b.add((SPRITE)GFORMAT.i(b.text(), p.regs.value(reg)));
/* 163 */             b.NL(8);
/*     */             
/* 165 */             super.hoverInfo(b, reg);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 174 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 179 */       activeSet((this.p.f().realm().regions() > 1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Reslist
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final GuiSection pop;
/*     */     
/*     */     Reslist(Deal deal, final DealParty p) {
/* 190 */       super(Dic.¤¤Resource);
/* 191 */       icon((SPRITE)(UI.icons()).s.storage);
/* 192 */       body().setDim(UIDealConfig.BW, UIDealConfig.BH);
/* 193 */       this.pop = (GuiSection)new UIPicker<TRADABLE>(p.resources, 16, TR.ALL())
/*     */         {
/*     */           protected void addToRow(GuiSection row, final GETTER<TRADABLE> g)
/*     */           {
/* 197 */             GuiSection s = new GuiSection()
/*     */               {
/*     */                 protected void hoverInfoSelf(GUI_BOX box)
/*     */                 {
/* 201 */                   GBox b = (GBox)box;
/* 202 */                   b.title(((TRADABLE)g.get()).name);
/* 203 */                   b.textLL((p.f() == FACTIONS.player()) ? Dic.¤¤buyPrice : Dic.¤¤sellPrice);
/* 204 */                   b.tab(6);
/* 205 */                   b.add((SPRITE)GFORMAT.i(b.text(), ((p.f() == FACTIONS.player()) ? p.npc().buyer((TRADABLE)g.get()).addPrice(1) : p.npc().seller((TRADABLE)g.get()).removePrice(1))));
/* 206 */                   b.NL();
/* 207 */                   b.textLL(Dic.¤¤Tariff);
/* 208 */                   b.tab(6);
/* 209 */                   b.add((SPRITE)GFORMAT.i(b.text(), TradeManager.totalFee((p.f() == FACTIONS.player()) ? p.f() : (Faction)p.npc(), (p.f() == FACTIONS.player()) ? (Faction)p.npc() : p.f(), RD.DIST().distance((Faction)p.npc()), (TRADABLE)g.get(), 1)));
/* 210 */                   b.NL();
/* 211 */                   super.hoverInfoSelf(box);
/*     */                 }
/*     */               };
/*     */ 
/*     */             
/* 216 */             s.addRelBody(8, DIR.E, (SPRITE)new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 220 */                     text.add('/');
/* 221 */                     GFORMAT.i(text, p.resources.max(g.get()));
/*     */                   }
/*     */                 });
/* 224 */             s.body().incrW(64.0D);
/* 225 */             s.addRelBody(8, DIR.E, (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 229 */                     GFORMAT.i(text, p.valueResource((TRADABLE)g.get(), p.resources.get(g.get())));
/*     */                   }
/* 231 */                 }).hh((SPRITE)(UI.icons()).s.money));
/* 232 */             s.addRelBody(128, DIR.E, (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 236 */                     int am = p.resources.get(g.get());
/* 237 */                     if (am == 0)
/* 238 */                       am = 1; 
/* 239 */                     GFORMAT.i(text, (p.valueResource((TRADABLE)g.get(), am) / am));
/* 240 */                     text.s();
/* 241 */                     text.add(UIDealConfig.¤¤item);
/*     */                   }
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   public void hoverInfoGet(GBox b) {}
/* 248 */                 }).r(DIR.E));
/* 249 */             row.addRelBody(8, DIR.E, (RENDEROBJ)s);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 259 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 264 */       activeSet(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Sum
/*     */     extends GInputInt
/*     */   {
/*     */     Sum(final DealParty party) {
/* 275 */       super((INT.INTE)party.credits, true, true);
/* 276 */       body().setHeight(UIDealConfig.BH);
/* 277 */       addRelBody(4, DIR.W, (SPRITE)(UI.icons()).s.money);
/* 278 */       addRelBody(8, DIR.E, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 282 */               text.add('(');
/* 283 */               GFORMAT.i(text, party.credits.max());
/* 284 */               text.add(')');
/*     */             }
/*     */           });
/* 287 */       body().setWidth(UIDealConfig.BW);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */