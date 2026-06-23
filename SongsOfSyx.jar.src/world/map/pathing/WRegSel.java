/*     */ package world.map.pathing;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import util.data.BOOLEANO;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WRegSel
/*     */   implements BOOLEANO<Region>
/*     */ {
/*     */   private static Region home;
/*     */   private static Faction faction;
/*     */   
/*  19 */   private static final WRegSel DUMDUM = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  23 */         return true;
/*     */       }
/*     */     };
/*     */   
/*  27 */   private static final WRegSel DUMMY = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  31 */         return (t != WRegSel.home);
/*     */       }
/*     */     };
/*     */   
/*  35 */   private static final WRegSel CAPITOLS = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  39 */         return t.capitol();
/*     */       }
/*     */     };
/*     */   
/*  43 */   private static final WRegSel SINGLE = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  47 */         return (t == WRegSel.home);
/*     */       }
/*     */     };
/*     */   
/*  51 */   private static final WRegSel FACTION = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  55 */         return (t.faction() == WRegSel.faction);
/*     */       }
/*     */     };
/*     */   
/*  59 */   private static final WRegSel ENEMYFACTION = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  63 */         if (WRegSel.faction == null)
/*  64 */           return (t.faction() == FACTIONS.player()); 
/*  65 */         return (t.faction() != null && DIP.WAR().is(t.faction(), WRegSel.faction));
/*     */       }
/*     */     };
/*     */   
/*  69 */   private static final WRegSel ENEMY = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  73 */         return DIP.WAR().is(t.faction(), WRegSel.faction);
/*     */       }
/*     */     };
/*     */   
/*     */   public static WRegSel DUMMY() {
/*  78 */     return DUMDUM;
/*     */   }
/*     */   
/*     */   public static WRegSel DUMMY(Region home) {
/*  82 */     WRegSel.home = home;
/*  83 */     return DUMMY;
/*     */   }
/*     */   
/*     */   public static WRegSel CAPITOLS() {
/*  87 */     return CAPITOLS;
/*     */   }
/*     */   
/*     */   public static WRegSel SINGLE(Region home) {
/*  91 */     WRegSel.home = home;
/*  92 */     return SINGLE;
/*     */   }
/*     */   
/*     */   public static WRegSel FACTION(Faction home) {
/*  96 */     faction = home;
/*  97 */     return FACTION;
/*     */   }
/*     */   
/*     */   public static WRegSel ENEMYFACTION(Faction home) {
/* 101 */     faction = home;
/* 102 */     return ENEMYFACTION;
/*     */   }
/*     */   
/*     */   public static WRegSel ENEMY(Faction home) {
/* 106 */     faction = home;
/* 107 */     return ENEMY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WRegSel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */