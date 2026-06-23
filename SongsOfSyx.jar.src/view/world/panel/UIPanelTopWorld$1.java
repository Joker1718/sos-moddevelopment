/*     */ package view.world.panel;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ import view.world.WorldView;
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
/*     */ class null
/*     */   extends UIPanelTopButtL
/*     */ {
/*     */   private final GAME.Cache cache;
/*     */   private int neighs;
/*     */   private double trust;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/*  52 */     super($anonymous0);
/*     */     
/*  54 */     this.cache = new GAME.Cache(60);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected double valueNext() {
/*  60 */     cache();
/*  61 */     return this.trust;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/*  66 */     cache();
/*  67 */     return this.trust;
/*     */   }
/*     */   
/*     */   private void cache() {
/*  71 */     if (!this.cache.shouldAndReset()) {
/*     */       return;
/*     */     }
/*  74 */     this.trust = 10.0D;
/*  75 */     this.neighs = 0;
/*     */     
/*  77 */     for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/*  78 */       FactionNPC f = (FactionNPC)FACTIONS.NPCs().get(fi);
/*  79 */       if (RD.DIST().factionHasRegionBorderingPlayer((Faction)f)) {
/*  80 */         this.trust = Math.min(ROPINION.trust().get(f), this.trust);
/*  81 */         this.neighs++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/*  88 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/*  93 */     cache();
/*  94 */     return this.neighs;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/*  99 */     selectedSet(w.UI.factions.openIs());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 104 */     w.UI.factions.open(null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 109 */     GBox b = (GBox)text;
/* 110 */     b.title(Dic.¤¤Factions);
/* 111 */     hov(b, DIP.ALLY());
/* 112 */     hov(b, DIP.VASSAL());
/* 113 */     hov(b, DIP.PACT());
/* 114 */     hov(b, DIP.TRADE());
/* 115 */     hov(b, (DipStance)DIP.WAR());
/*     */   }
/*     */   
/*     */   private void hov(GBox b, DipStance stance) {
/* 119 */     b.textLL(stance.name);
/* 120 */     b.tab(6);
/* 121 */     b.add((SPRITE)b.text().add(stance.player().size()));
/* 122 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIPanelTopWorld$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */