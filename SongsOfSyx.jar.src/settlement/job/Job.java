/*     */ package settlement.job;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.job.SETT_JOB;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import view.tool.PlacableMessages;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Job
/*     */   implements SETT_JOB, MAPPED
/*     */ {
/*     */   public static boolean overwrite;
/*     */   static final int NOTHING = 0;
/*  38 */   static final ArrayListGrower<Job> all = new ArrayListGrower();
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
/*  49 */   final byte index = (byte)all.add(this);
/*  50 */   final Coo coo = new Coo();
/*     */   int tile;
/*     */   final CharSequence name;
/*     */   final SPRITE icon;
/*     */   private final String key;
/*     */   
/*     */   Job(String key, CharSequence name, SPRITE icon) {
/*  57 */     this.name = name;
/*  58 */     this.icon = icon;
/*  59 */     this.key = "JOB_" + key;
/*     */   }
/*     */   
/*     */   protected boolean get(int tx, int ty) {
/*  63 */     this.coo.set(tx, ty);
/*  64 */     this.tile = tx + ty * SETT.TWIDTH;
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public final int tile() {
/*  69 */     return this.tile;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void cancel(int tx, int ty) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void jobReserve(RESOURCE r) {
/*  83 */     if (!jobReserveCanBe()) {
/*  84 */       throw new RuntimeException();
/*     */     }
/*  86 */     if (r != resourceCurrentlyNeeded())
/*  87 */       throw new RuntimeException(String.valueOf(r) + " " + String.valueOf(r)); 
/*  88 */     (SETT.JOBS()).state.set(StateManager.State.RESERVED, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean jobReservedIs(RESOURCE r) {
/*  93 */     return ((SETT.JOBS()).state.is((COORDINATE)this.coo, StateManager.State.RESERVED) && r == resourceCurrentlyNeeded());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void jobReserveCancel(RESOURCE r) {
/*  98 */     if ((SETT.JOBS()).state.is((COORDINATE)this.coo, StateManager.State.RESERVED)) {
/*  99 */       (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, this);
/*     */     }
/*     */   }
/*     */   
/*     */   public final boolean jobReserveCanBe() {
/* 104 */     return ((SETT.JOBS()).state.get((COORDINATE)this.coo) == StateManager.State.RESERVABLE);
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE jobCoo() {
/* 109 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void extraHovInfo(GBox box) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RESOURCE res() {
/* 128 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final RBIT jobResourceBitToFetch() {
/* 133 */     if (resourceCurrentlyNeeded() != null)
/* 134 */       return (resourceCurrentlyNeeded()).bit; 
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int jobResourcesNeeded(Humanoid skill) {
/* 140 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected CharSequence problem(int tx, int ty, boolean overwrite) {
/* 145 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 146 */       return PlacableMessages.¤¤ROOM_BLOCK; 
/* 147 */     if (becomesSolid() && 
/* 148 */       (SETT.PLACA()).willBlock.is(tx, ty)) {
/* 149 */       return PlacableMessages.¤¤BLOCK_WILL;
/*     */     }
/*     */     
/* 152 */     if (!overwrite && 
/* 153 */       (SETT.JOBS()).getter.is(tx, ty)) {
/* 154 */       return PlacableMessages.¤¤JOB_BLOCK;
/*     */     }
/*     */ 
/*     */     
/* 158 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence lockText() {
/* 163 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ToolConfig config() {
/* 168 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isConstruction() {
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/* 176 */   private static CharSequence ¤¤claimed = "Is Claimed";
/* 177 */   private static CharSequence ¤¤claimedNot = "Is Unclaimed";
/* 178 */   private static CharSequence ¤¤resources = "¤This job needs {0} to complete, which is unobtainable in your city.";
/* 179 */   private static CharSequence ¤¤dormant = "¤Job is inactive and needs to be manually activated before it will be performed.";
/* 180 */   private static CharSequence ¤¤blocked = "¤An adjacent job is blocking this job and must be performed prior to this.";
/* 181 */   private static CharSequence ¤¤unreachable = "¤Job is unreachable. It will eventually be performed, but it will be difficult for your subjects.";
/*     */   
/*     */   static {
/* 184 */     D.ts(Job.class);
/*     */   }
/*     */   public void hover(GBox box) {
/* 187 */     if (this.icon != (SPRITES.icons()).m.questionmark) {
/* 188 */       box.add(this.icon);
/* 189 */       box.text(this.name);
/* 190 */       box.NL(8);
/*     */     } 
/*     */     
/* 193 */     StateManager.State state = (SETT.JOBS()).state.get(this.tile);
/*     */     
/* 195 */     if (res() != null) {
/* 196 */       int am = resAmount();
/* 197 */       int n = am - jobResourcesNeeded(null);
/* 198 */       box.setResource(res(), n, am);
/* 199 */       box.NL();
/*     */     } 
/*     */     
/* 202 */     if (state == StateManager.State.RESERVED) {
/* 203 */       box.add((SPRITE)box.text().normalify2().add(¤¤claimed));
/* 204 */       box.NL();
/*     */     } else {
/* 206 */       box.add((SPRITE)box.text().normalify2().add(¤¤claimedNot));
/* 207 */       box.NL();
/*     */     } 
/*     */     
/* 210 */     box.NL(8);
/* 211 */     if (!(SETT.PATH()).reachability.is((COORDINATE)this.coo)) {
/* 212 */       box.add((SPRITE)box.text().errorify().add(¤¤unreachable));
/* 213 */       box.NL();
/*     */     } 
/* 215 */     if (state == StateManager.State.DORMANT) {
/* 216 */       box.add((SPRITE)box.text().errorify().add(¤¤dormant));
/* 217 */       box.NL();
/*     */     } 
/* 219 */     if (state == StateManager.State.BLOCKED) {
/* 220 */       box.add((SPRITE)box.text().errorify().add(¤¤blocked));
/* 221 */       box.NL();
/*     */     } 
/*     */     
/* 224 */     RESOURCE res = resourceCurrentlyNeeded();
/* 225 */     if (res != null && state != StateManager.State.RESERVED && !(SETT.PATH()).finders.resource.normal.has(res)) {
/* 226 */       GText t = box.text();
/* 227 */       t.add(¤¤resources);
/* 228 */       t.insert(0, res.names);
/* 229 */       t.errorify();
/*     */       
/* 231 */       if (res.specialHelpText != null) {
/* 232 */         t.s();
/* 233 */         t.add(res.specialHelpText);
/*     */       } 
/*     */       
/* 236 */       box.add((res.icon()).big);
/* 237 */       box.add((SPRITE)t);
/* 238 */       box.NL();
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
/*     */   public boolean becomesSolid() {
/* 250 */     return false;
/*     */   }
/*     */   
/*     */   public boolean needsRipe() {
/* 254 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void doSomethingExtraRender() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public String key() {
/* 265 */     return this.key;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 270 */     return this.index;
/*     */   }
/*     */   
/*     */   abstract void renderBelow(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData.RenderIterator paramRenderIterator, int paramInt);
/*     */   
/*     */   abstract void renderAbove(SPRITE_RENDERER paramSPRITE_RENDERER, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   abstract void init(int paramInt1, int paramInt2);
/*     */   
/*     */   abstract boolean becomesSolidNext();
/*     */   
/*     */   public abstract RESOURCE resourceCurrentlyNeeded();
/*     */   
/*     */   public abstract int resAmount();
/*     */   
/*     */   public abstract PlacableMulti placer();
/*     */   
/*     */   public abstract Terrain.TerrainTile becomes(int paramInt1, int paramInt2);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */