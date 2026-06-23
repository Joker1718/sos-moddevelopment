/*     */ package world.battle;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Resolver
/*     */ {
/*     */   private final ResolverSide a;
/*     */   private final ResolverSide b;
/*     */   private final ResolverPlayer iplayer;
/*  17 */   private final ResolverSide.RCount count = new ResolverSide.RCount();
/*     */   
/*     */   Resolver() {
/*  20 */     this.iplayer = new ResolverPlayer();
/*  21 */     this.a = new ResolverSide();
/*  22 */     this.b = new ResolverSide();
/*     */   }
/*     */ 
/*     */   
/*     */   void init(Side A, Side B) {
/*  27 */     init(A, 0.0D, B, 0.0D);
/*     */     
/*  29 */     ResolverSide winner = this.a;
/*  30 */     ResolverSide looser = this.b;
/*  31 */     if (this.b.powerBalance > this.a.powerBalance) {
/*  32 */       winner = this.b;
/*  33 */       looser = this.a;
/*     */     } 
/*     */     
/*  36 */     if (looser.player) {
/*  37 */       if (((ResolverSide.ResolverUnit)looser.us.get(0)).unit.a() != null) {
/*  38 */         COORDINATE ret = Util.retTile(((ResolverSide.ResolverUnit)looser.us.get(0)).unit.a());
/*  39 */         if (ret == null) {
/*  40 */           ((ResolverSide.ResolverUnit)looser.us.get(0)).count(this.count.clear(), 1.0D, true);
/*     */         } else {
/*  42 */           looser.retreatCoo.set(ret);
/*     */           
/*  44 */           ((ResolverSide.ResolverUnit)looser.us.get(0)).count(this.count.clear(), retreatValue(looser), true);
/*     */         } 
/*     */       } 
/*  47 */       looser.count(this.count.clear(), autoValue(looser), false);
/*  48 */       winner.count(this.count.clear(), autoValue(winner), false);
/*  49 */       this.iplayer.battle(looser, winner);
/*     */       
/*     */       return;
/*     */     } 
/*  53 */     if (((Side.SideUnit)looser.side.us.get(0)).r() != null) {
/*     */       return;
/*     */     }
/*     */     
/*  57 */     WArmy retreater = ((Side.SideUnit)looser.side.us.get(0)).a();
/*     */     
/*  59 */     double retValue = retreatValue(looser);
/*  60 */     if (retValue < 1.0D) {
/*  61 */       COORDINATE ret = Util.retTile(retreater);
/*     */       
/*  63 */       if (ret != null) {
/*     */         
/*  65 */         retreater.teleport(ret.x(), ret.y());
/*  66 */         if (winner.player) {
/*  67 */           this.iplayer.enemyWithdraws(winner, looser);
/*     */           return;
/*     */         } 
/*  70 */         ((ResolverSide.ResolverUnit)looser.us.get(0)).extract(retValue);
/*  71 */         BattleListener.notify(winner, looser);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  77 */     looser.count(this.count.clear(), autoValue(looser), false);
/*  78 */     winner.count(this.count.clear(), autoValue(winner), false);
/*     */     
/*  80 */     if (winner.player) {
/*  81 */       if (((ResolverSide.ResolverUnit)looser.us.get(0)).unit.a() != null) {
/*  82 */         COORDINATE ret = Util.retTile(((ResolverSide.ResolverUnit)looser.us.get(0)).unit.a());
/*  83 */         if (ret == null) {
/*  84 */           ((ResolverSide.ResolverUnit)looser.us.get(0)).count(this.count.clear(), 1.0D, true);
/*     */         } else {
/*  86 */           ((ResolverSide.ResolverUnit)looser.us.get(0)).count(this.count.clear(), retreatValue(looser), true);
/*     */           
/*  88 */           looser.retreatCoo.set(ret);
/*     */         } 
/*     */       } 
/*  91 */       if (((ResolverSide.ResolverUnit)winner.us.get(0)).unit.a() != null) {
/*  92 */         COORDINATE ret = Util.retTile(((ResolverSide.ResolverUnit)winner.us.get(0)).unit.a());
/*  93 */         if (ret != null) {
/*  94 */           winner.retreatCoo.set(ret);
/*     */         }
/*     */       } 
/*  97 */       this.iplayer.battle(winner, looser);
/*     */       
/*     */       return;
/*     */     } 
/* 101 */     BattleListener.notify(winner, looser);
/*     */     
/* 103 */     looser.extract(1.0D);
/* 104 */     winner.extract(1.0D - winner.powerBalance);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double retreatValue(ResolverSide retreater) {
/* 110 */     double d = 1.0D - retreater.powerBalance;
/* 111 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 112 */     return d;
/*     */   }
/*     */   
/*     */   public static double autoValue(ResolverSide side) {
/* 116 */     if (side.powerBalance < 0.5D)
/* 117 */       return 1.0D; 
/* 118 */     return CLAMP.d(1.0D - side.powerBalance, 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean besige(Side besieger, Side besieged, boolean first) {
/* 125 */     Region reg = ((Side.SideUnit)besieged.us.get(0)).r();
/* 126 */     double extra = (RD.MILITARY()).power.getD(reg) * (RD.MILITARY()).fort.getD(reg);
/*     */     
/* 128 */     init(besieger, 0.0D, besieged, extra);
/* 129 */     ((ResolverSide.ResolverUnit)this.b.us.get(0)).defences = extra;
/*     */     
/* 131 */     if (this.a.player) {
/* 132 */       if (this.b.powerBalance > this.a.powerBalance) {
/* 133 */         this.a.count(this.count, 1.0D, false);
/* 134 */         this.b.count(this.count, 1.0D - this.b.powerBalance, false);
/*     */       } else {
/* 136 */         this.b.count(this.count, 1.0D, false);
/* 137 */         this.a.count(this.count, 1.0D - this.a.powerBalance, false);
/*     */       } 
/* 139 */       this.iplayer.besige(this.a, this.b);
/* 140 */       return true;
/*     */     } 
/* 142 */     if (this.b.player && first) {
/* 143 */       this.b.count(this.count, 1.0D - this.b.powerBalance, false);
/*     */       
/* 145 */       this.a.count(this.count, 1.0D - this.a.powerBalance, false);
/* 146 */       if (this.b.men() > 0) {
/* 147 */         this.iplayer.sallyOut(this.b, this.a);
/* 148 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     if (this.b.powerBalance > this.a.powerBalance) {
/* 153 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 158 */     if (this.b.player && reg.capitol()) {
/* 159 */       this.iplayer.invadeCapitol(this.a);
/* 160 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 164 */     ((ResolverSide.ResolverUnit)this.a.us.get(0)).extract(1.0D - this.a.powerBalance);
/* 165 */     ((ResolverSide.ResolverUnit)this.b.us.get(0)).extract(1.0D);
/* 166 */     Util.conquer(this.a.side, RND.rFloat(), RND.rFloat(), reg, ((Side.SideUnit)besieger.us.get(0)).faction());
/* 167 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(Side A, double powA, Side B, double powB) {
/* 174 */     if (A.us.size() == 0) {
/* 175 */       throw new RuntimeException();
/*     */     }
/* 177 */     if (B.us.size() == 0) {
/* 178 */       throw new RuntimeException();
/*     */     }
/* 180 */     if (!Util.enemies(((Side.SideUnit)A.us.get(0)).faction(), ((Side.SideUnit)B.us.get(0)).faction())) {
/* 181 */       throw new RuntimeException();
/*     */     }
/* 183 */     for (Side.SideUnit u : A.us) {
/* 184 */       powA += u.power();
/*     */     }
/*     */     
/* 187 */     for (Side.SideUnit u : B.us) {
/* 188 */       powB += u.power();
/*     */     }
/*     */     
/* 191 */     double pI = 1.0D / (powA + powB);
/*     */     
/* 193 */     this.a.init(A, powA * pI);
/* 194 */     this.b.init(B, powB * pI);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Resolver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */