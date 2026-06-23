/*     */ package world.battle;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BattleListener
/*     */ {
/*  22 */   private static CharSequence ¤¤siege = "{0} forces have taken control of {1}.";
/*  23 */   private static CharSequence ¤¤battle = "An army of {0} defeated an army of {1} near {2}.";
/*     */   
/*     */   public static int changeI;
/*     */   
/*     */   static {
/*  28 */     D.ts(BattleListener.class);
/*     */   }
/*     */ 
/*     */   
/*  32 */   static final ArrayListGrower<BattleListener> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BattleListener() {
/*  45 */     all.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private static Bitmap1D map = new Bitmap1D(FACTIONS.MAX(), false);
/*  54 */   private static int[] ulosses = Alloc.ii(Math.max(128, FACTIONS.MAX()));
/*     */   
/*     */   static void notify(ResolverSide winner, ResolverSide looser) {
/*  57 */     int cas = 0;
/*  58 */     int loss = 0;
/*     */     int i;
/*  60 */     for (i = 0; i < winner.us.size(); i++)
/*  61 */       cas += ((ResolverSide.ResolverUnit)winner.us.get(i)).losses; 
/*  62 */     for (i = 0; i < looser.us.size(); i++) {
/*  63 */       loss += ((ResolverSide.ResolverUnit)looser.us.get(i)).losses;
/*     */     }
/*  65 */     Str.TMP.clear().add(¤¤battle);
/*  66 */     Str.TMP.insert(0, FACTIONS.name(((ResolverSide.ResolverUnit)winner.us.get(0)).unit.faction()));
/*  67 */     Str.TMP.insert(1, FACTIONS.name(((ResolverSide.ResolverUnit)looser.us.get(0)).unit.faction()));
/*  68 */     int tx = ((ResolverSide.ResolverUnit)looser.us.get(0)).unit.x();
/*  69 */     int ty = ((ResolverSide.ResolverUnit)looser.us.get(0)).unit.y();
/*  70 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*  71 */     if (reg == null) {
/*  72 */       WRegFinder.RegDist r = (WORLD.PATH()).regFinder.single(tx, ty, WRegFinder.Treaty.DUMMY, WRegSel.DUMMY(null));
/*  73 */       if (r != null) {
/*  74 */         reg = r.reg;
/*     */       }
/*     */     } 
/*     */     
/*  78 */     if (reg != null) {
/*  79 */       Str.TMP.insert(2, (CharSequence)reg.info.name());
/*     */     }
/*  81 */     WORLD.LOG().log(((ResolverSide.ResolverUnit)winner.us.get(0)).unit.faction(), ((ResolverSide.ResolverUnit)looser.us.get(0)).unit.faction(), (UI.icons()).s.sword, (CharSequence)Str.TMP, tx, ty);
/*     */     
/*  83 */     noti(winner, true, loss, cas, looser.side);
/*  84 */     noti(looser, false, cas, loss, winner.side);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void notify(Side side, Region reg) {
/*  90 */     map.clear();
/*  91 */     for (Side.SideUnit u : side.us) {
/*  92 */       if (u.a() != null)
/*  93 */         for (BattleListener li : all) {
/*  94 */           li.siege(u.a(), reg);
/*     */         } 
/*  96 */       if (u.faction() != null && !map.get(u.faction().index())) {
/*  97 */         map.set(u.faction().index(), true);
/*     */         
/*  99 */         for (BattleListener li : all) {
/* 100 */           li.siege(u.faction(), reg);
/*     */         }
/*     */       } 
/*     */     } 
/* 104 */     Str.TMP.clear().add(¤¤siege);
/* 105 */     Str.TMP.insert(0, FACTIONS.name(((Side.SideUnit)side.us.get(0)).faction()));
/* 106 */     Str.TMP.insert(1, (CharSequence)reg.info.name());
/* 107 */     WORLD.LOG().log(((Side.SideUnit)side.us.get(0)).faction(), reg.faction(), (UI.icons()).s.degrade, (CharSequence)Str.TMP, reg.cx(), reg.cy());
/*     */   }
/*     */   
/*     */   private static void noti(ResolverSide side, boolean victory, int kills, int cas, Side against) {
/* 111 */     map.clear(); int i;
/* 112 */     for (i = 0; i < side.us.size(); i++) {
/* 113 */       if (((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction() != null) {
/* 114 */         int mi = ((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction().index();
/* 115 */         if (!map.get(mi)) {
/* 116 */           ulosses[mi] = 0;
/* 117 */           map.set(mi, true);
/*     */         } 
/* 119 */         ulosses[((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction().index()] = ulosses[((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction().index()] + ((ResolverSide.ResolverUnit)side.us.get(i)).losses;
/*     */       } 
/*     */     } 
/* 122 */     map.clear();
/* 123 */     for (i = 0; i < side.us.size(); i++) {
/*     */       
/* 125 */       if (((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction() != null) {
/* 126 */         int mi = ((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction().index();
/* 127 */         if (!map.get(mi)) {
/* 128 */           map.set(mi, true);
/* 129 */           for (BattleListener li : all) {
/* 130 */             li.battle(((ResolverSide.ResolverUnit)side.us.get(i)).unit.faction(), victory, ulosses[mi], kills, ((Side.SideUnit)against.us.get(0)).faction());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 136 */     for (int ui = 0; ui < side.us.size(); ui++) {
/* 137 */       if (((ResolverSide.ResolverUnit)side.us.get(ui)).unit.a() != null)
/* 138 */         for (BattleListener li : all)
/* 139 */           li.battle(((ResolverSide.ResolverUnit)side.us.get(ui)).unit.a(), victory, cas, kills, ((Side.SideUnit)against.us.get(0)).faction());  
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract void battle(Faction paramFaction1, boolean paramBoolean, int paramInt1, int paramInt2, Faction paramFaction2);
/*     */   
/*     */   public abstract void battle(WArmy paramWArmy, boolean paramBoolean, int paramInt1, int paramInt2, Faction paramFaction);
/*     */   
/*     */   public abstract void siege(WArmy paramWArmy, Region paramRegion);
/*     */   
/*     */   public abstract void siege(Faction paramFaction, Region paramRegion);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\BattleListener.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */