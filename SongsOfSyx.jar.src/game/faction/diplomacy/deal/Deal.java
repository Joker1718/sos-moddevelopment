/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import util.Debugger;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class Deal
/*     */ {
/*     */   public final DealParty player;
/*     */   public final DealParty npc;
/*     */   public final DealBools bools;
/*     */   public boolean clearDeal;
/*     */   
/*     */   public Deal() {
/*  21 */     DealRegs.RegData data = new DealRegs.RegData();
/*  22 */     this.player = new DealParty(this, data);
/*  23 */     this.npc = new DealParty(this, data);
/*  24 */     this.bools = new DealBools(this.player, this.npc);
/*     */   }
/*     */   
/*     */   public void setFactionAndClear(FactionNPC faction) {
/*  28 */     setFactionAndClear(faction, true);
/*     */   }
/*     */   
/*     */   public void setFactionAndClear(FactionNPC faction, boolean clearDeal) {
/*  32 */     setFactionAndClear(faction, clearDeal, Debugger.dummy);
/*     */   }
/*     */   
/*     */   public void setFactionAndClear(FactionNPC faction, boolean clearDeal, Debugger d) {
/*  36 */     this.clearDeal = clearDeal;
/*  37 */     this.player.init((Faction)FACTIONS.player(), (Faction)faction, faction);
/*  38 */     this.npc.init((Faction)faction, (Faction)FACTIONS.player(), faction);
/*  39 */     this.bools.init(true, clearDeal, d);
/*  40 */     this.dupI = -1;
/*     */   }
/*     */   
/*     */   public boolean canBeAccepted() {
/*  44 */     return (hasDeal() && ((int)valueCredits() >= 0 || this.can));
/*     */   }
/*     */ 
/*     */   
/*     */   public double execute(boolean changeOpinion) {
/*  49 */     double v = opinionChange();
/*  50 */     this.player.execute();
/*  51 */     this.npc.execute();
/*  52 */     this.bools.execute();
/*     */     
/*  54 */     if (changeOpinion && this.player.f() == FACTIONS.player())
/*  55 */       ROPINION.GIFTS().makeDeal(this.npc.npc(), v); 
/*  56 */     if (this.npc.npc().isActive()) {
/*  57 */       setFactionAndClear(this.npc.npc(), this.clearDeal);
/*     */     }
/*  59 */     return v;
/*     */   }
/*     */   
/*  62 */   int dupI = -1;
/*     */ 
/*     */   
/*     */   private int cvalue;
/*     */ 
/*     */   
/*     */   private boolean can = false;
/*     */ 
/*     */ 
/*     */   
/*     */   public double valueCredits() {
/*  73 */     this.can = false;
/*  74 */     this.dupI = VIEW.RI();
/*     */     
/*  76 */     this.cvalue = (int)this.bools.value();
/*  77 */     this.cvalue = (int)(this.cvalue + this.player.value());
/*  78 */     this.cvalue = (int)(this.cvalue - this.npc.value());
/*     */     
/*  80 */     return this.cvalue;
/*     */   }
/*     */   
/*     */   public boolean hasDeal() {
/*  84 */     for (DealBool b : this.bools.all()) {
/*  85 */       if (b.is())
/*  86 */         return true; 
/*  87 */     }  return !(!has(this.npc) && !has(this.player));
/*     */   }
/*     */   
/*     */   public boolean has(DealParty p) {
/*  91 */     if (p.credits.get() != 0)
/*  92 */       return true; 
/*  93 */     for (DealRegs.DealReg r : this.player.regs.all()) {
/*  94 */       if (r.is())
/*  95 */         return true; 
/*     */     } 
/*  97 */     for (TRADABLE r : TR.ALL()) {
/*  98 */       if (p.resources.get(r) != 0)
/*  99 */         return true; 
/*     */     } 
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public double opinionChange() {
/* 105 */     return opinionChangeD();
/*     */   }
/*     */ 
/*     */   
/*     */   public double opinionChangeD() {
/* 110 */     double c = 25.0D * valueCredits();
/* 111 */     c /= this.npc.selfWorth();
/*     */     
/* 113 */     return c;
/*     */   }
/*     */   
/*     */   public double getWorthOfOpinion(double opinion) {
/* 117 */     return opinion * this.npc.selfWorth() / 25.0D;
/*     */   }
/*     */   
/*     */   public double betrayal() {
/* 121 */     return this.bools.betrayal();
/*     */   }
/*     */   
/*     */   public void hoverBetrayal(GBox b) {
/* 125 */     this.bools.betrayalHover(b);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\Deal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */