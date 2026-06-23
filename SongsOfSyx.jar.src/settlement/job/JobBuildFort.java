/*     */ package settlement.job;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.audio.SoundRace;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.value.Lock;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TFortification;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JobBuildFort
/*     */   extends JobBuild
/*     */ {
/*     */   private final TFortification fort;
/*  33 */   private static CharSequence ¤¤dStairs = "¤Stairs are used for getting access to the top of fortifications. Should be placed adjacent to one.";
/*     */   
/*     */   static {
/*  36 */     D.ts(JobBuildFort.class);
/*     */   }
/*     */   
/*     */   static LIST<Job> make() {
/*  40 */     ArrayList<Job> all = new ArrayList((SETT.TERRAIN()).FORTIFICATIONS.all().size());
/*  41 */     for (TFortification s : (SETT.TERRAIN()).FORTIFICATIONS.all()) {
/*  42 */       all.add(new JobBuildFort(s));
/*     */     }
/*  44 */     return (LIST<Job>)all;
/*     */   }
/*     */   
/*     */   public static class JobBuildForts
/*     */   {
/*     */     public final LIST<Job> all;
/*     */     final JobComboPlacer pla;
/*  51 */     public final Job build_stairs = new JobBuildFort.Stairs();
/*     */     
/*     */     JobBuildForts() {
/*  54 */       ArrayList<Job> all = new ArrayList((SETT.TERRAIN()).FORTIFICATIONS.all().size());
/*  55 */       for (TFortification s : (SETT.TERRAIN()).FORTIFICATIONS.all()) {
/*  56 */         all.add(new JobBuildFort(s));
/*     */       }
/*  58 */       this.all = (LIST<Job>)all;
/*  59 */       this.pla = new JobComboPlacer(all.join((Object[])new Job[] { this.build_stairs }, ), "FORTIFICATIONS");
/*     */     }
/*     */     
/*     */     public Job getPlacable() {
/*  63 */       return this.pla.current();
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
/*     */ 
/*     */ 
/*     */   
/*     */   JobBuildFort(TFortification fort) {
/*  78 */     super("FORT_" + fort.key(), fort.resource, fort.resAmount, true, fort.tile.name(), fort.desc, fort.tile.getIcon());
/*  79 */     this.fort = fort;
/*     */   }
/*     */ 
/*     */   
/*     */   void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/*  84 */     for (DIR d : DIR.ORTHO) {
/*  85 */       if ((SETT.FLOOR()).getter.is(tx, ty, d) || (SETT.JOBS()).getter.get(tx, ty, d) instanceof JobBuildFort)
/*  86 */         mask |= d.mask(); 
/*     */     } 
/*  88 */     (SPRITES.cons()).BIG.dashed.render(r, mask, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence lockText() {
/*  93 */     Str.TMP.clear().add(Dic.¤¤Requires);
/*  94 */     Str.TMP.NL();
/*  95 */     boolean has = false;
/*  96 */     for (Lock<Faction> i : (Iterable<Lock<Faction>>)this.fort.reqs.all()) {
/*  97 */       if (!i.unlocker.inUnlocked(FACTIONS.player())) {
/*  98 */         Str.TMP.NL();
/*  99 */         has = true;
/* 100 */         Str.TMP.add(i.unlocker.name);
/*     */       } 
/*     */     } 
/* 103 */     if (has)
/* 104 */       return (CharSequence)Str.TMP; 
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double constructionTime(Humanoid skill) {
/* 110 */     return 50.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SoundRace constructSound() {
/* 115 */     return this.fort.sound;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean construct(int tx, int ty) {
/* 120 */     if (this.fort.resource != null)
/* 121 */       GAME.player().res().inc(this.fort.resource, FResources.RTYPE.CONSTRUCTION, -this.fort.resAmount); 
/* 122 */     this.fort.tile.placeFixed(tx, ty);
/* 123 */     (SETT.FLOOR()).clearer.clear(tx, ty);
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean becomesSolid() {
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isConstruction() {
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   static final class Stairs
/*     */     extends JobBuild {
/*     */     Stairs() {
/* 140 */       super("STAIRS", RESOURCES.STONE(), 2, false, (SETT.TERRAIN()).FSTAIRS.name(), JobBuildFort.¤¤dStairs, (SETT.TERRAIN()).FSTAIRS.getIcon());
/*     */     }
/*     */ 
/*     */     
/*     */     protected double constructionTime(Humanoid skill) {
/* 145 */       return 50.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean construct(int tx, int ty) {
/* 150 */       GAME.player().res().inc(this.res, FResources.RTYPE.CONSTRUCTION, -this.resAmount);
/* 151 */       (SETT.TERRAIN()).FSTAIRS.placeFixed(tx, ty);
/* 152 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected SoundRace constructSound() {
/* 158 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 164 */       Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 165 */       if (t instanceof TFortification.Normal && ((SETT.PATH()).availability.get(tx, ty)).player < 0.0D) {
/* 166 */         return null;
/*     */       }
/* 168 */       if (super.problem(tx, ty, overwrite) != null) {
/* 169 */         return super.problem(tx, ty, overwrite);
/*     */       }
/*     */       
/* 172 */       if ((SETT.PATH()).solidity.is(tx, ty))
/* 173 */         return PlacableMessages.¤¤SOLID_BLOCK; 
/* 174 */       if (t.clearing().needs() && !t.clearing().can())
/* 175 */         return PlacableMessages.¤¤MISC; 
/* 176 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void renderAbove(SPRITE_RENDERER r, int x, int y, int mask, int tx, int ty) {
/* 181 */       (SPRITES.cons()).BIG.dashed.render(r, 0, x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public Terrain.TerrainTile becomes(int tx, int ty) {
/* 186 */       return (Terrain.TerrainTile)(SETT.TERRAIN()).FSTAIRS;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ToolConfig config() {
/* 193 */       return (SETT.JOBS()).build_fort.pla.get(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Terrain.TerrainTile becomes(int tx, int ty) {
/* 201 */     return (Terrain.TerrainTile)this.fort.tile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 208 */     return (SETT.JOBS()).build_fort.pla.get(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildFort.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */