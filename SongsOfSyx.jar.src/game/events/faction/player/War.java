/*     */ package game.events.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipWarPlayer;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADDiv;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ class War
/*     */ {
/*  36 */   private final double WAR_INTERVAL = (16 * TIME.secondsPerDay());
/*  37 */   private double warCount = 0.0D;
/*  38 */   private FactionNPC warner = null;
/*  39 */   private double teachings = 0.0D;
/*     */   
/*     */   War() {
/*  42 */     BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly()
/*     */       {
/*     */         public double vGet(FactionNPC f)
/*     */         {
/*  46 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Player f) {
/*  51 */           return War.this.teachings;
/*     */         }
/*     */       };
/*     */     
/*  55 */     BoosterValue bo = new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo(WarMessages.¤¤teachings, (SPRITE)(UI.icons()).s.book), -0.15D, false);
/*  56 */     bo.add((BOOSTABLES.BEHAVIOUR()).LOYALTY);
/*  57 */     bo.add((BOOSTABLES.BEHAVIOUR()).SUBMISSION);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  63 */     file.d(this.warCount);
/*  64 */     file.i((this.warner == null) ? -1 : this.warner.index());
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  68 */     this.warCount = file.d();
/*  69 */     int fi = file.i();
/*  70 */     this.warner = (fi >= 0) ? (FactionNPC)FACTIONS.all().get(fi) : null;
/*     */   }
/*     */   
/*     */   public void clear() {
/*  74 */     this.warCount = 0.0D;
/*  75 */     this.warner = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void updateAll(double ds) {
/*  82 */     this.teachings -= ds / 16.0D * TIME.secondsPerDay();
/*  83 */     if (this.teachings < 0.0D) {
/*  84 */       this.teachings = 0.0D;
/*     */     }
/*  86 */     if (SETT.INVADOR().invading())
/*     */       return; 
/*  88 */     if (DIP.overlord((Faction)FACTIONS.player()) != null) {
/*     */       return;
/*     */     }
/*  91 */     if (DIP.WAR().any((Faction)FACTIONS.player())) {
/*  92 */       this.warner = null;
/*     */       
/*     */       return;
/*     */     } 
/*  96 */     DipWarPlayer w = DIP.WAR_PLAYER();
/*     */     
/*  98 */     if (this.warner != null) {
/*  99 */       if (!this.warner.isActive()) {
/* 100 */         this.warner = null;
/*     */         return;
/*     */       } 
/* 103 */       if (this.warner.request.has())
/*     */         return; 
/* 105 */       if (!w.potential(this.warner)) {
/* 106 */         this.warner = null;
/* 107 */         this.warCount = -this.WAR_INTERVAL;
/*     */         return;
/*     */       } 
/* 110 */       start(this.warner);
/* 111 */       this.warner = null;
/*     */     } 
/*     */     
/* 114 */     double attack = 0.0D;
/*     */     
/* 116 */     for (FactionNPC f : w.potential()) {
/* 117 */       attack += Math.max(1.0D - ROPINION.trust().get(f), 0.0D);
/*     */     }
/*     */     
/* 120 */     this.warCount += attack * ds;
/*     */ 
/*     */ 
/*     */     
/* 124 */     if (this.warCount < this.WAR_INTERVAL) {
/*     */       return;
/*     */     }
/* 127 */     this.warCount -= this.WAR_INTERVAL;
/*     */     
/* 129 */     attack *= RND.rFloat();
/*     */     
/* 131 */     for (FactionNPC f : w.potential()) {
/* 132 */       attack -= Math.max(1.0D - ROPINION.trust().get(f), 0.0D);
/*     */       
/* 134 */       if (attack <= 0.0D) {
/*     */         
/* 136 */         this.warner = f;
/* 137 */         WarMessages.warn(f);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean updateDay(FactionNPC f) {
/* 147 */     if (SETT.INVADOR().invading())
/* 148 */       return false; 
/* 149 */     if (DIP.overlord((Faction)FACTIONS.player()) != null)
/* 150 */       return false; 
/* 151 */     if (!DIP.WAR().any((Faction)FACTIONS.player()))
/* 152 */       return false; 
/* 153 */     if (DIP.WAR().is(f)) {
/* 154 */       return false;
/*     */     }
/* 156 */     double maxAmount = FACTIONS.player().offensivePower() * (1.0D + AD.stats().repF().getD(FACTIONS.player()) * 2.0D);
/* 157 */     for (Faction ff : DIP.WAR().all((Faction)FACTIONS.player())) {
/* 158 */       maxAmount -= ff.offensivePower();
/*     */     }
/* 160 */     if (maxAmount < 0.0D) {
/* 161 */       return false;
/*     */     }
/* 163 */     if (DIP.WAR_PLAYER().willing(f)) {
/* 164 */       DIP.WAR().set(f);
/* 165 */       WarMessages.join(f);
/* 166 */       return true;
/*     */     } 
/* 168 */     if (DIP.WAR_PLAYER().proxy(f)) {
/* 169 */       proxyMove(f);
/*     */     }
/*     */     
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean proxyMove(FactionNPC f) {
/* 177 */     LIST<WRegFinder.RegDist> proxies = (WORLD.PATH()).regFinder.all((Faction)f, WRegFinder.Treaty.FACTION_REACHABLE_NPC_TRADE, WRegSel.DUMMY());
/* 178 */     int am = 0;
/* 179 */     for (WRegFinder.RegDist d : proxies) {
/* 180 */       if (d.reg.faction() != null && d.reg.faction() != f && DIP.WAR().is((Faction)FACTIONS.player(), d.reg.faction())) {
/* 181 */         am++;
/*     */       }
/*     */     } 
/* 184 */     if (am == 0)
/* 185 */       return false; 
/* 186 */     am = RND.rInt(am);
/* 187 */     for (WRegFinder.RegDist d : proxies) {
/*     */       
/* 189 */       am--;
/* 190 */       if (d.reg.faction() != null && d.reg.faction() != f && DIP.WAR().is((Faction)FACTIONS.player(), d.reg.faction()) && am <= 0) {
/* 191 */         int a = proxyMove(f, (FactionNPC)d.reg.faction());
/* 192 */         WarMessages.proxy((FactionNPC)d.reg.faction(), f, a);
/* 193 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 197 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int proxyMove(FactionNPC fromFaction, FactionNPC toFaction) {
/* 203 */     for (int ai = 0; ai < fromFaction.armies().all().size(); ai++) {
/* 204 */       WArmy a = (WArmy)fromFaction.armies().all().get(ai);
/* 205 */       if (AD.men(null).get(a) > 50) {
/* 206 */         return proxyMove(a, toFaction);
/*     */       }
/*     */     } 
/*     */     
/* 210 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int proxyMove(WArmy fromArmy, FactionNPC toFaction) {
/* 216 */     int ii = RND.rInt(toFaction.armies().all().size());
/* 217 */     int am = 0;
/* 218 */     for (int ai = 0; ai < toFaction.armies().all().size(); ai++) {
/*     */ 
/*     */       
/* 221 */       WArmy toArmy = (WArmy)toFaction.armies().all().getC(ii + ai);
/* 222 */       am += proxyMove(fromArmy, toArmy);
/*     */     } 
/*     */ 
/*     */     
/* 226 */     if (fromArmy.divs().size() > 0) {
/* 227 */       COORDINATE c = WORLD.PATH().rnd(toFaction.capitolRegion());
/* 228 */       WArmy to = (WORLD.ENTITIES()).armies.create(c.x(), c.y(), (Faction)toFaction);
/* 229 */       if (to != null)
/* 230 */         am += proxyMove(fromArmy, to); 
/*     */     } 
/* 232 */     return am;
/*     */   }
/*     */   
/*     */   private int proxyMove(WArmy fromArmy, WArmy toArmy) {
/* 236 */     int am = 0;
/* 237 */     while (fromArmy.divs().size() > 0 && toArmy.divs().canAdd()) {
/*     */       
/* 239 */       ADDiv toMove = fromArmy.divs().get(fromArmy.divs().size() - 1);
/*     */       
/* 241 */       am += toMove.men();
/* 242 */       toMove.reassign(toArmy);
/*     */     } 
/* 244 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   private void start(FactionNPC f) {
/* 249 */     DipWarPlayer w = DIP.WAR_PLAYER();
/* 250 */     if (w.willing(this.warner)) {
/* 251 */       DIP.WAR().set(f);
/* 252 */       WarMessages.start(f);
/* 253 */     } else if (w.potential(this.warner)) {
/*     */       boolean any; int aa;
/* 255 */       DIP.secondSincestartInc((Faction)f, (Faction)FACTIONS.player(), -0.5D);
/*     */       
/* 257 */       switch (RND.rInt(3)) {
/*     */         case 0:
/* 259 */           any = false;
/* 260 */           for (FactionNPC ff : RD.DIST().neighs()) {
/* 261 */             if (f != ff) {
/* 262 */               any = true;
/* 263 */               double am = RND.rFloat(3.0D) / (1.0D + (BOOSTABLES.NOBLE()).TOLERANCE.get((BOOSTABLE_O)(ff.king()).induvidual));
/* 264 */               ROPINION.OTHER().poison(ff, am);
/*     */             } 
/*     */           } 
/* 267 */           if (any) {
/* 268 */             WarMessages.poision(f);
/*     */             return;
/*     */           } 
/*     */           break;
/*     */         
/*     */         case 1:
/* 274 */           aa = RND.rInt(FACTIONS.player().realm().all().size());
/*     */           
/* 276 */           for (Region reg : FACTIONS.player().realm().all()) {
/* 277 */             aa--;
/* 278 */             if (aa <= 0 && !reg.capitol()) {
/* 279 */               (RD.OWNER()).affiliation.set(reg, 0);
/* 280 */               WarMessages.ngo(f, reg);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 289 */       this.teachings = 1.0D;
/* 290 */       WarMessages.teachings(f);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\War.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */