/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.diplomacy.deal.DealDrawfter;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.data.GETTER;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ public final class UIFactions
/*     */ {
/*  18 */   private final Deal deal = new Deal();
/*     */ 
/*     */   
/*  21 */   private final GETTER.GETTER_IMP<FactionNPC> getter = new GETTER.GETTER_IMP<FactionNPC>()
/*     */     {
/*     */       public void set(FactionNPC t)
/*     */       {
/*  25 */         super.set(t);
/*  26 */         if (get() != null)
/*  27 */           UIFactions.this.deal.setFactionAndClear(t, true); 
/*     */       }
/*     */     };
/*     */   
/*  31 */   final Hoverer hov = new Hoverer();
/*     */   
/*  33 */   private final UIFactionList list = new UIFactionList(ISidePanel.HEIGHT);
/*  34 */   private final UIFaction detail = new UIFaction(this.getter, this.deal, 1280 - this.list.section().body().width() - 16, ISidePanel.HEIGHT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void open(FactionNPC r) {
/*  42 */     VIEW.world().activate();
/*  43 */     this.getter.set(r);
/*     */     
/*  45 */     (VIEW.world()).panels.add(this.list, true);
/*  46 */     if (r != null) {
/*  47 */       (VIEW.world()).panels.add(this.detail, false);
/*  48 */       this.deal.setFactionAndClear((FactionNPC)this.getter.get(), true);
/*  49 */       (VIEW.world()).window.centererTile.set(r.cx(), r.cy());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean openIs() {
/*  55 */     return (VIEW.world()).panels.added(this.list);
/*     */   }
/*     */   
/*     */   public boolean openIs(Faction f) {
/*  59 */     return ((VIEW.world()).panels.added(this.detail) && this.detail.f() == f);
/*     */   }
/*     */   
/*     */   public boolean diploIs(Faction f) {
/*  63 */     return ((VIEW.world()).panels.added(this.detail) && this.detail.f() == f && this.detail.dipIS());
/*     */   }
/*     */   
/*     */   public void openPeace(FactionNPC other) {
/*  67 */     this.deal.setFactionAndClear(other, true);
/*  68 */     open(other);
/*  69 */     DealDrawfter.draftPeace(this.deal, other, true);
/*  70 */     this.detail.dip();
/*     */   }
/*     */ 
/*     */   
/*     */   public void openTrade(FactionNPC other) {
/*  75 */     open(other);
/*  76 */     this.deal.setFactionAndClear(other, true);
/*  77 */     this.deal.bools.TRADE.setOn();
/*  78 */     DealDrawfter.draft(this.deal, true, true);
/*  79 */     this.detail.dip();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openBuy(FactionNPC other, TRADABLE res) {
/*  85 */     open(other);
/*  86 */     this.deal.setFactionAndClear(other, true);
/*  87 */     this.deal.npc.resources.set(res, 1);
/*  88 */     this.detail.dip();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openSell(FactionNPC other, TRADABLE res) {
/*  94 */     open(other);
/*  95 */     this.deal.setFactionAndClear(other, true);
/*  96 */     if (this.deal.player.resources.max(res) > 0)
/*  97 */       this.deal.player.resources.set(res, 1); 
/*  98 */     this.detail.dip();
/*     */   }
/*     */ 
/*     */   
/*     */   public void openDip(FactionNPC other) {
/* 103 */     open(other);
/* 104 */     this.deal.setFactionAndClear(other, true);
/* 105 */     this.detail.dip();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX b, Faction r) {
/* 110 */     this.hov.hover(b, r);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(int tx, int ty) {
/* 115 */     Faction f = (Faction)(WORLD.REGIONS()).faction.get(tx, ty);
/* 116 */     this.list.hover(f);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX b, Royalty r) {
/* 120 */     Court.hover(b, r);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFactions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */