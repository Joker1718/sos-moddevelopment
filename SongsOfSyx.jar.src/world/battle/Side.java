/*     */ package world.battle;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ class Side {
/*     */   public final ArrayList<SideUnit> us;
/*     */   private int divisions;
/*  19 */   private final ArrayList<SideUnit> all = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   public Side() {
/*  21 */     while (this.all.hasRoom()) {
/*  22 */       this.all.add(new SideUnit());
/*     */     }
/*  24 */     this.us = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.unitTmp = new SideUnit();
/*  29 */     this.ui = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*  30 */     this.di = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   }
/*     */   private final SideUnit unitTmp;
/*     */   private final int[] ui;
/*     */   private final int[] di;
/*     */   
/*     */   void clear() {
/*  37 */     this.all.add((Iterable)this.us);
/*  38 */     this.us.clearSloppy();
/*  39 */     this.divisions = 0;
/*     */   }
/*     */   
/*     */   public Side copy() {
/*  43 */     Side s = new Side();
/*  44 */     for (int ui = 0; ui < this.us.size(); ui++) {
/*  45 */       SideUnit u = (SideUnit)this.us.get(ui);
/*  46 */       SideUnit n = new SideUnit();
/*     */       
/*  48 */       n.copy(u);
/*  49 */       s.us.add(n);
/*     */     } 
/*     */     
/*  52 */     s.divisions = this.divisions;
/*     */     
/*  54 */     for (int i = 0; i < this.di.length; i++) {
/*  55 */       s.ui[i] = this.ui[i];
/*  56 */       s.di[i] = this.di[i];
/*     */     } 
/*     */ 
/*     */     
/*  60 */     return s;
/*     */   }
/*     */   
/*     */   public void debug() {
/*  64 */     LOG.ln(Integer.valueOf(divs()));
/*  65 */     for (int i = 0; i < divs(); i++)
/*  66 */       LOG.ln("" + div(i).men() + " " + div(i).men() + " " + String.valueOf(div(i).name())); 
/*     */   }
/*     */   
/*     */   public void add(WArmy a) {
/*  70 */     int max = (Config.battle()).DIVISIONS_PER_ARMY - this.divisions;
/*  71 */     for (SideUnit s : this.us) {
/*  72 */       if (s.a() == a)
/*     */         return; 
/*     */     } 
/*  75 */     this.unitTmp.set(a, max);
/*  76 */     inited();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Region reg) {
/*  82 */     int max = (Config.battle()).DIVISIONS_PER_ARMY - this.divisions;
/*     */     
/*  84 */     for (SideUnit s : this.us) {
/*  85 */       if (s.r() == reg)
/*     */         return; 
/*     */     } 
/*  88 */     this.unitTmp.set(reg, max);
/*     */     
/*  90 */     inited();
/*     */   }
/*     */ 
/*     */   
/*     */   private void inited() {
/*  95 */     if (this.unitTmp.a() != null && this.unitTmp.divs() <= 0) {
/*     */       return;
/*     */     }
/*  98 */     for (int i = 0; i < this.us.size(); i++) {
/*  99 */       if (((SideUnit)this.us.get(i)).isSameAs(this.unitTmp)) {
/*     */         return;
/*     */       }
/*     */     } 
/* 103 */     SideUnit u = (SideUnit)this.all.removeLast();
/*     */     
/* 105 */     u.copy(this.unitTmp);
/* 106 */     this.us.add(u);
/*     */     
/* 108 */     for (int j = 0; j < u.divs(); j++) {
/* 109 */       this.ui[this.divisions] = this.us.size() - 1;
/* 110 */       this.di[this.divisions] = j;
/* 111 */       this.divisions++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int divs() {
/* 116 */     return this.divisions;
/*     */   }
/*     */   
/*     */   public WDIV div(int di) {
/* 120 */     SideUnit u = (SideUnit)this.us.get(this.ui[di]);
/* 121 */     int i = this.di[di];
/* 122 */     if (i < 0 || i >= u.divs())
/* 123 */       return null; 
/* 124 */     return u.div(i);
/*     */   }
/*     */   
/*     */   public int ui(int di) {
/* 128 */     return this.ui[di];
/*     */   }
/*     */   
/*     */   public SideUnit divUnit(int di) {
/* 132 */     return (SideUnit)this.us.get(this.ui[di]);
/*     */   }
/*     */ 
/*     */   
/*     */   static final class SideUnit
/*     */   {
/*     */     private int type;
/*     */     
/*     */     private static final int T_ARMY = 0;
/*     */     
/*     */     private static final int T_GARRISON = 1;
/*     */     
/*     */     private int regionI;
/*     */     
/*     */     private int armyI;
/*     */     private int maxDivs;
/*     */     
/*     */     void copy(SideUnit o) {
/* 150 */       this.type = o.type;
/* 151 */       this.regionI = o.regionI;
/* 152 */       this.armyI = o.armyI;
/* 153 */       this.maxDivs = o.maxDivs;
/*     */     }
/*     */     
/*     */     public SideUnit set(Region reg, int maxDivs) {
/* 157 */       this.type = 1;
/* 158 */       this.regionI = reg.index();
/* 159 */       this.maxDivs = maxDivs;
/* 160 */       return this;
/*     */     }
/*     */     
/*     */     public SideUnit set(WArmy a, int maxDivs) {
/* 164 */       this.type = 0;
/* 165 */       this.armyI = a.armyIndex();
/* 166 */       this.maxDivs = maxDivs;
/* 167 */       return this;
/*     */     }
/*     */     
/*     */     public int divs() {
/* 171 */       switch (this.type) { case 0:
/* 172 */           return CLAMP.i(a().divs().size(), 0, this.maxDivs);
/* 173 */         case 1: return CLAMP.i(RD.MILITARY().divisions(r()).size(), 0, this.maxDivs); }
/* 174 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public WDIV div(int index) {
/* 179 */       switch (this.type) { case 0:
/* 180 */           return (WDIV)a().divs().get(index);
/* 181 */         case 1: return (WDIV)RD.MILITARY().divisions(r()).get(index); }
/* 182 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public Faction faction() {
/* 187 */       switch (this.type) { case 0:
/* 188 */           return a().faction();
/* 189 */         case 1: return r().faction(); }
/* 190 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public double power() {
/* 195 */       switch (this.type) { case 0:
/* 196 */           return ((a().faction() == FACTIONS.player()) ? 0.8D : 1.0D) * AD.power().get(a());
/* 197 */         case 1: return ((r().faction() == FACTIONS.player()) ? 0.8D : 1.0D) * (RD.MILITARY()).power.getD(r()); }
/* 198 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public int x() {
/* 203 */       switch (this.type) { case 0:
/* 204 */           return a().ctx();
/* 205 */         case 1: return r().cx(); }
/* 206 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public int y() {
/* 211 */       switch (this.type) { case 0:
/* 212 */           return a().cty();
/* 213 */         case 1: return r().cy(); }
/* 214 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public int men() {
/* 219 */       switch (this.type) { case 0:
/* 220 */           return AD.men(null).get(a());
/* 221 */         case 1: return (RD.MILITARY()).garrison.get(r()); }
/* 222 */        throw new RuntimeException();
/*     */     }
/*     */ 
/*     */     
/*     */     public WArmy a() {
/* 227 */       if (this.type == 0)
/* 228 */         return (WORLD.ENTITIES()).armies.get(this.armyI); 
/* 229 */       return null;
/*     */     }
/*     */     
/*     */     public Region r() {
/* 233 */       if (this.type == 1)
/* 234 */         return WORLD.REGIONS().getByIndex(this.regionI); 
/* 235 */       return null;
/*     */     }
/*     */     
/*     */     public boolean isSameAs(SideUnit o) {
/* 239 */       if (this.type == o.type)
/* 240 */         return !((this.type != 1 || this.regionI != o.regionI) && (this.type != 0 || this.armyI != o.armyI)); 
/* 241 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Conflict
/*     */   {
/* 250 */     public final Side A = new Side();
/* 251 */     public final Side B = new Side();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void clear() {
/* 258 */       this.A.clear();
/* 259 */       this.B.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Side.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */