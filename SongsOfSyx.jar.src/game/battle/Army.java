/*     */ package game.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public final class Army
/*     */ {
/*     */   private final int index;
/*     */   private final LIST<Div> divisions;
/*     */   private final ArrayList<Div> ordered;
/*     */   
/*  21 */   public final Cache men = new Cache()
/*     */     {
/*     */       protected int count()
/*     */       {
/*  25 */         int a = 0;
/*  26 */         for (int di = 0; di < Army.this.divisions.size(); di++) {
/*  27 */           Div d = (Div)Army.this.divisions.get(di);
/*  28 */           a += d.menNrOf();
/*     */         } 
/*  30 */         return a;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int menMax;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int bit;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int index() {
/*  54 */     return this.index;
/*     */   }
/*     */   
/*     */   public LIST<Div> divisions() {
/*  58 */     return this.divisions;
/*     */   }
/*     */   
/*     */   public LIST<Div> ordered() {
/*  62 */     return (LIST<Div>)this.ordered;
/*     */   }
/*     */   
/*     */   public void setDivAtOrderedIndex(Div toBeReplaced, Div replacer) {
/*  66 */     if (this.ordered.removeOrdered(replacer) == -1)
/*  67 */       throw new RuntimeException(); 
/*  68 */     int oi = this.ordered.indexOf(toBeReplaced);
/*  69 */     if (oi < 0)
/*  70 */       throw new RuntimeException(); 
/*  71 */     this.ordered.insert(oi, replacer);
/*     */   }
/*     */   
/*     */   public Div getNextEmptyOrdered() {
/*  75 */     for (int di = 0; di < this.ordered.size(); di++) {
/*  76 */       Div d = (Div)this.ordered.get(di);
/*  77 */       if (d.info.men() == 0 && d.menNrOf() == 0) {
/*  78 */         return d;
/*     */       }
/*     */     } 
/*  81 */     return null;
/*     */   }
/*     */   
/*     */   public int men() {
/*  85 */     return this.men.i();
/*     */   }
/*     */   
/*     */   public int menMax() {
/*  89 */     return this.menMax;
/*     */   }
/*     */   
/*     */   public Army enemy() {
/*  93 */     return (Army)GAME.ARMIES().armies().get((this.index + 1) % 2);
/*     */   }
/*     */   
/*     */   public double morale() {
/*  97 */     return (GAME.ARMIES()).factors.morale(this);
/*     */   }
/*     */   
/*     */   public Faction faction() {
/* 101 */     if (this == GAME.ARMIES().player())
/* 102 */       return (Faction)FACTIONS.player(); 
/* 103 */     return (Faction)FACTIONS.otherFaction();
/*     */   }
/*     */   
/* 106 */   Army(ArrayList<Army> armies, ArrayList<Div> divisions) { this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 110 */           for (Div d : Army.this.ordered) {
/* 111 */             file.i(d.indexArmy());
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 118 */           Army.this.men.recount();
/*     */           
/* 120 */           Army.this.ordered.clearSloppy();
/* 121 */           for (int i = 0; i < Army.this.divisions.size(); i++) {
/* 122 */             Army.this.ordered.add(Army.this.divisions.get(file.i()));
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 128 */           Army.this.men.recount();
/* 129 */           Army.this.ordered.clearSloppy();
/* 130 */           Army.this.ordered.add((Iterable)Army.this.divisions); } }; this.index = armies.add(this); ArrayList<Div> divs = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */     for (int i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++);
/*     */     this.divisions = (LIST<Div>)divs;
/*     */     this.ordered = new ArrayList((Iterable)divs);
/*     */     this.menMax = (Config.battle()).MEN_PER_DIVISION * (Config.battle()).DIVISIONS_PER_ARMY;
/* 135 */     this.bit = 1 << this.index; } public boolean defender() { return true; }
/*     */   
/*     */   public static abstract class Cache { private boolean dirty; private int i;
/*     */     
/*     */     public Cache() {
/* 140 */       this.dirty = true;
/* 141 */       this.i = 0;
/*     */     }
/*     */     public int i() {
/* 144 */       if (this.dirty) {
/* 145 */         this.i = count();
/* 146 */         this.dirty = false;
/*     */       } 
/* 148 */       return this.i;
/*     */     }
/*     */     
/*     */     public void recount() {
/* 152 */       this.dirty = true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract int count(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean player() {
/* 162 */     return (GAME.ARMIES().player() == this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Army.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */