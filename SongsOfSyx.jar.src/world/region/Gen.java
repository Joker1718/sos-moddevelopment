/*     */ package world.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gen
/*     */ {
/*  22 */   private final WRegFinder rr = new WRegFinder();
/*     */   private static final int aveSize = 8;
/*  24 */   private Bitmap1D handsOff = new Bitmap1D(1023, false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WRegFinder.Treaty treaty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void generatePlayer(int playerX, int playerY) {
/*  46 */     Region r = (Region)(WORLD.REGIONS()).map.get(playerX, playerY);
/*  47 */     r.fationSet((Faction)FACTIONS.player(), false);
/*  48 */     r.setCapitol();
/*  49 */     r.info.name().clear().add((CharSequence)(FACTIONS.player()).name);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     LIST<WRegFinder.RegDist> dd = this.rr.all(r, this.treaty, WRegSel.DUMMY(r));
/*  55 */     if (dd.size() > 2) {
/*  56 */       this.handsOff.set(((WRegFinder.RegDist)dd.rnd()).reg.index(), true);
/*     */     }
/*     */ 
/*     */     
/*  60 */     int[] size = {
/*  61 */         1, 
/*  62 */         3, 
/*  63 */         5 };
/*     */     byte b;
/*     */     int i, arrayOfInt1[];
/*  66 */     for (i = (arrayOfInt1 = size).length, b = 0; b < i; ) { int s = arrayOfInt1[b];
/*  67 */       LIST<WRegFinder.RegDist> ddd = this.rr.all(r, this.treaty, WRegSel.DUMMY(r));
/*     */       
/*  69 */       int am = 0;
/*  70 */       for (WRegFinder.RegDist d : ddd) {
/*  71 */         if (d.reg.faction() != null)
/*     */           continue; 
/*  73 */         if (this.handsOff.get(d.reg.index()))
/*     */           continue; 
/*  75 */         if (!create(d.reg)) {
/*     */           break;
/*     */         }
/*  78 */         ((FactionNPC)d.reg.faction()).sanctified = true;
/*  79 */         spread(d.reg, RND.rInt(s));
/*  80 */         am++;
/*  81 */         if (am >= 2 + s / 2) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean create(Region reg) {
/*  91 */     FactionNPC f = FACTIONS.activateNext(reg, null, false);
/*  92 */     return (f != null);
/*     */   }
/*     */ 
/*     */   
/*     */   private void generateKingdoms() {
/*  97 */     SPRITES.loader().init();
/*  98 */     ArrayList<Region> regs = new ArrayList((Iterable)WORLD.REGIONS().active());
/*  99 */     regs.shuffle();
/*     */     
/* 101 */     int amount = 3 * regs.size() / 4;
/*     */     
/* 103 */     while (amount > 0 && regs.size() > 0) {
/* 104 */       Region r = (Region)regs.removeLast();
/* 105 */       if (r.faction() != null)
/*     */         continue; 
/* 107 */       if (this.handsOff.get(r.index()))
/*     */         continue; 
/* 109 */       FactionNPC f = FACTIONS.activateNext(r, null, false);
/* 110 */       if (f == null) {
/*     */         break;
/*     */       }
/* 113 */       amount -= spread(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int spread(Region home) {
/* 125 */     int amount = RND.rInt(16);
/* 126 */     home.fationSet(home.faction(), false);
/* 127 */     LIST<WRegFinder.RegDist> ddd = this.rr.all(home, this.treaty, WRegSel.DUMMY(home));
/*     */     
/* 129 */     int k = 1;
/* 130 */     for (int i = 0; i < amount && i < ddd.size(); i++) {
/* 131 */       ((WRegFinder.RegDist)ddd.get(i)).reg.fationSet(home.faction(), false);
/* 132 */       k++;
/*     */     } 
/* 134 */     return k;
/*     */   }
/*     */   
/*     */   private int spread(Region home, int amount) {
/* 138 */     home.fationSet(home.faction(), false);
/* 139 */     LIST<WRegFinder.RegDist> ddd = this.rr.all(home, this.treaty, WRegSel.DUMMY(home));
/* 140 */     int k = 1;
/* 141 */     for (int i = 0; i < amount && i < ddd.size(); i++) {
/* 142 */       ((WRegFinder.RegDist)ddd.get(i)).reg.fationSet(home.faction(), false);
/* 143 */       k++;
/*     */     } 
/* 145 */     return k;
/*     */   }
/*     */   Gen(RD.RDInit init, ACTION loadprint) {
/* 148 */     this.treaty = new WRegFinder.Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */         {
/* 152 */           if (to == null)
/* 153 */             return true; 
/* 154 */           if (to.faction() == null)
/* 155 */             return true; 
/* 156 */           if (to != null && to.faction() != origin.faction())
/* 157 */             return false; 
/* 158 */           if (Gen.this.handsOff.get(to.index()))
/* 159 */             return false; 
/* 160 */           return true;
/*     */         }
/*     */       };
/*     */     loadprint.exe();
/*     */     if (!(WORLD.REGIONS()).player.active())
/*     */       return; 
/*     */     WORLD.RD().saver().clear();
/*     */     while (FACTIONS.NPCs().size() > 0)
/*     */       FACTIONS.remove((FactionNPC)FACTIONS.NPCs().get(0), false); 
/*     */     RD.PROSPECT().generate();
/*     */     loadprint.exe();
/*     */     generatePlayer((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy());
/*     */     generateKingdoms();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Gen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */