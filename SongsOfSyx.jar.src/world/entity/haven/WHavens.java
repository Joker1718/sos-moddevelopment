/*     */ package world.entity.haven;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.WEntityConstructor;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public class WHavens
/*     */   extends WEntityConstructor<WHaven> {
/*  23 */   public final LIST<WHavenType> types = WHavenType.types();
/*  24 */   final Stack<WHaven> free = new Stack(64);
/*  25 */   private final WHavenFactionData[] factions = new WHavenFactionData[FACTIONS.MAX()];
/*  26 */   private final WHavenType[][] racemap = new WHavenType[RACES.all().size()][0];
/*     */ 
/*     */   
/*     */   private final Player player;
/*     */ 
/*     */   
/*     */   public final INFO info;
/*     */ 
/*     */ 
/*     */   
/*     */   public WHavens(LISTE<WEntityConstructor<?>> tot) throws IOException {
/*  37 */     super(tot, false); D.t(this);
/*     */     this.info = new INFO(Dic.¤¤havens, D.g("HavenD", "Havens are smaller settlements that contain individuals of a specific race. They are independent, but can join a faction if their criteria are met and the faction controls the region in which they are located."));
/*  39 */     for (int i = 0; i < this.factions.length; i++) {
/*  40 */       this.factions[i] = new WHavenFactionData(this, i);
/*     */     }
/*  42 */     for (Race race : RACES.all()) {
/*  43 */       int am = 0;
/*  44 */       for (WHavenType t : this.types) {
/*  45 */         if (t.race == race)
/*  46 */           am++; 
/*     */       } 
/*  48 */       this.racemap[race.index()] = new WHavenType[am];
/*  49 */       for (WHavenType t : this.types) {
/*  50 */         if (t.race == race) {
/*  51 */           this.racemap[race.index][--am] = t;
/*     */         }
/*     */       } 
/*     */     } 
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
/*  66 */     this.player = new Player(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected WHaven create() {
/*  71 */     if (!this.free.isEmpty()) {
/*  72 */       return (WHaven)this.free.pop();
/*     */     }
/*  74 */     return new WHaven();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  79 */     this.player.update(ds);
/*     */   }
/*     */   
/*     */   public WHaven create(int tx, int ty, WHavenType type, double size, CharSequence name) {
/*  83 */     WHaven c = create();
/*  84 */     c.add(tx, ty, type, size, name);
/*     */     
/*  86 */     if (c.added()) {
/*  87 */       return c;
/*     */     }
/*     */     
/*  90 */     this.free.push(c);
/*  91 */     return null;
/*     */   } protected void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     WHavenFactionData[] arrayOfWHavenFactionData;
/*  96 */     for (i = (arrayOfWHavenFactionData = this.factions).length, b = 0; b < i; ) { WHavenFactionData d = arrayOfWHavenFactionData[b];
/*  97 */       d.dirty = true; b++; }
/*  98 */      this.player.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 103 */     this.player.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 108 */     this.player.load(file); byte b; int i; WHavenFactionData[] arrayOfWHavenFactionData;
/* 109 */     for (i = (arrayOfWHavenFactionData = this.factions).length, b = 0; b < i; ) { WHavenFactionData d = arrayOfWHavenFactionData[b];
/* 110 */       d.dirty = true;
/*     */       b++; }
/*     */   
/*     */   } public void setDirty(Faction f) {
/* 114 */     if (f == null)
/*     */       return; 
/* 116 */     (this.factions[f.index()]).dirty = true;
/*     */   }
/*     */   
/*     */   public boolean available(Race race) {
/* 120 */     return ((this.racemap[race.index()]).length > 0);
/*     */   }
/*     */   
/*     */   public int current(Faction f, Race type) {
/* 124 */     int am = 0; byte b; int i; WHavenType[] arrayOfWHavenType;
/* 125 */     for (i = (arrayOfWHavenType = this.racemap[type.index()]).length, b = 0; b < i; ) { WHavenType t = arrayOfWHavenType[b];
/* 126 */       am = (int)(am + max(f, t) * this.player.get(f, t)); b++; }
/*     */     
/* 128 */     return am;
/*     */   }
/*     */   
/*     */   public int max(Faction f, Race type) {
/* 132 */     int am = 0; byte b; int i; WHavenType[] arrayOfWHavenType;
/* 133 */     for (i = (arrayOfWHavenType = this.racemap[type.index()]).length, b = 0; b < i; ) { WHavenType t = arrayOfWHavenType[b];
/* 134 */       am += max(f, t); b++; }
/*     */     
/* 136 */     return am;
/*     */   }
/*     */   
/*     */   public double replenishPerDay(Faction f, Race type) {
/* 140 */     double am = 0.0D; byte b; int i; WHavenType[] arrayOfWHavenType;
/* 141 */     for (i = (arrayOfWHavenType = this.racemap[type.index()]).length, b = 0; b < i; ) { WHavenType t = arrayOfWHavenType[b];
/* 142 */       am += replenishPerDay(f, t) * this.player.get(f, t);
/*     */       b++; }
/*     */     
/* 145 */     return am;
/*     */   }
/*     */   
/*     */   public int current(Faction f, WHavenType type) {
/* 149 */     this.factions[f.index()].init();
/* 150 */     return (int)(((this.factions[f.index()]).all[type.index()]).pop * this.player.get(f, type));
/*     */   }
/*     */   
/*     */   public int max(Faction f, WHavenType type) {
/* 154 */     this.factions[f.index()].init();
/* 155 */     return ((this.factions[f.index()]).all[type.index()]).pop;
/*     */   }
/*     */   
/*     */   public double replenishPerDay(Faction f, WHavenType type) {
/* 159 */     this.factions[f.index()].init();
/* 160 */     return ((this.factions[f.index()]).all[type.index()]).replenish * this.player.get(f, type);
/*     */   }
/*     */   
/*     */   public int camps(Faction f, WHavenType type) {
/* 164 */     this.factions[f.index()].init();
/* 165 */     return ((this.factions[f.index()]).all[type.index()]).camps;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHavens.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */