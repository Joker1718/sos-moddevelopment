/*     */ package world.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WDivStoredAll
/*     */ {
/*  30 */   private final WDivStored[] divs = new WDivStored[(Config.battle()).DIVISIONS_PER_ARMY];
/*     */   int amount;
/*  32 */   final int[] ramounts = new int[RACES.all().size()];
/*     */   private double upD;
/*     */   private int upDI;
/*     */   
/*     */   WDivStoredAll() {
/*  37 */     for (int i = 0; i < this.divs.length; i++)
/*  38 */       this.divs[i] = new WDivStored(i);  } void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     WDivStored[] arrayOfWDivStored;
/*  42 */     for (i = (arrayOfWDivStored = this.divs).length, b = 0; b < i; ) { WDivStored d = arrayOfWDivStored[b];
/*  43 */       d.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   void load(FileGetter file) throws IOException {
/*  48 */     this.amount = 0;
/*  49 */     Arrays.fill(this.ramounts, 0); byte b; int i; WDivStored[] arrayOfWDivStored;
/*  50 */     for (i = (arrayOfWDivStored = this.divs).length, b = 0; b < i; ) { WDivStored d = arrayOfWDivStored[b];
/*  51 */       d.load(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   WDivStored get(long data) {
/*  56 */     return this.divs[(int)(data & 0xFFFFL)];
/*     */   }
/*     */   
/*     */   public WArmy attachedArmy(Div div) {
/*  60 */     if (div.army() == GAME.ARMIES().enemy())
/*  61 */       return null; 
/*  62 */     return this.divs[div.index()].army();
/*     */   }
/*     */   
/*     */   public double daysToReturn(Div div) {
/*  66 */     if (this.divs[div.index()].men() > 0)
/*  67 */       return Math.max(0.0D, this.divs[div.index()].returnSecond() - TIME.currentSecond()) * TIME.secondsPerDayI(); 
/*  68 */     return -1.0D;
/*     */   }
/*     */   
/*     */   public WDIV get(Div div) {
/*  72 */     return this.divs[div.index()];
/*     */   }
/*     */   
/*     */   public void attach(WArmy a, Div div) {
/*  76 */     if (a != null) {
/*  77 */       for (ResSupply s : (RESOURCES.SUP()).ALL) {
/*  78 */         int am = s.amount(div.info.race(), div.menNrOf());
/*  79 */         if (am <= 0)
/*     */           continue; 
/*  81 */         am = CLAMP.i(am, 0, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource));
/*  82 */         if (am > 0) {
/*  83 */           s.resource.remove(am, FResources.RTYPE.ARMY_SUPPLY);
/*  84 */           AD.supplies().get(s).current().inc(a, am);
/*     */         } 
/*     */       } 
/*     */     }
/*  88 */     this.divs[div.index()].reassign(a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Humanoid i, Div div) {
/* 100 */     this.divs[div.index()].add(i);
/* 101 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 102 */       AD.supplies().get(e).current().inc(attachedArmy(div), e.stat().indu().get(i.indu()));
/*     */     }
/*     */   }
/*     */   
/*     */   public int total() {
/* 107 */     return this.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public int total(Race race) {
/* 112 */     if (race == null)
/* 113 */       return this.amount; 
/* 114 */     return this.ramounts[race.index];
/*     */   }
/*     */   
/*     */   void update(double ds) {
/* 118 */     this.upD += ds * 32.0D;
/*     */     
/* 120 */     while (this.upD > 1.0D) {
/* 121 */       this.upD--;
/*     */       
/* 123 */       if (!(SETT.ENTRY()).points.hasAny() || SETT.ENTRY().isClosed()) {
/*     */         return;
/*     */       }
/* 126 */       WDivStored d = this.divs[this.upDI];
/* 127 */       this.upDI++;
/* 128 */       this.upDI %= this.divs.length;
/*     */       
/* 130 */       if (!shouldReturn(d)) {
/*     */         continue;
/*     */       }
/* 133 */       COORDINATE cret = (SETT.ENTRY()).points.randomReachable(this.upDI);
/*     */       
/* 135 */       if (cret == null) {
/* 136 */         this.upD -= (int)this.upD;
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 142 */       Humanoid h = d.popSoldier(cret.x(), cret.y(), HTYPES.SUBJECT());
/*     */       
/* 144 */       if (h != null) {
/*     */         
/* 146 */         Div dd = (Div)GAME.ARMIES().player().divisions().get(d.index());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 151 */         if (dd.menNrOf() < (Config.battle()).MEN_PER_DIVISION) {
/* 152 */           h.setDivision(dd);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean shouldReturn(WDivStored d) {
/* 162 */     if (d.men() == 0) {
/* 163 */       return false;
/*     */     }
/* 165 */     if (d.army() != null) {
/* 166 */       if (d.men() > d.menTarget())
/* 167 */         return (d.returnSecond() < TIME.currentSecond()); 
/* 168 */       return false;
/*     */     } 
/*     */     
/* 171 */     return (d.returnSecond() < TIME.currentSecond());
/*     */   }
/*     */ 
/*     */   
/*     */   public Induvidual getSoldier(int id) {
/* 176 */     int div = id & 0xFFFF;
/* 177 */     int ii = id >>> 16 & 0xFFFF;
/* 178 */     if (div < this.divs.length) {
/* 179 */       WDivStored w = this.divs[div];
/* 180 */       if (ii < w.all.size()) {
/* 181 */         return (Induvidual)w.all.get(ii);
/*     */       }
/*     */     } 
/* 184 */     return null;
/*     */   }
/*     */   
/*     */   public static int getSoldierId(int index, int div) {
/* 188 */     int id = div;
/* 189 */     id |= index << 16;
/* 190 */     return id;
/*     */   }
/*     */   
/*     */   public Induvidual getSoldier(int index, int div) {
/* 194 */     int ii = index;
/* 195 */     if (div < this.divs.length) {
/* 196 */       WDivStored w = this.divs[div];
/* 197 */       if (ii < w.all.size()) {
/* 198 */         return (Induvidual)w.all.get(ii);
/*     */       }
/*     */     } 
/* 201 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int soldiers(int div) {
/* 206 */     if (div < this.divs.length) {
/* 207 */       WDivStored w = this.divs[div];
/* 208 */       return w.all.size();
/*     */     } 
/* 210 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivStoredAll.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */