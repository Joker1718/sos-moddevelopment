/*     */ package game.save;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameSpec;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameSaver
/*     */ {
/*  26 */   private final KeyMap<Savable> smap = new KeyMap();
/*  27 */   private final ArrayListGrower<Savable> before = new ArrayListGrower();
/*  28 */   private final ArrayListGrower<Savable> all = new ArrayListGrower();
/*     */   
/*  30 */   private final ArrayListGrower<ACTION.ACTION_O<Path>> beforeSave = new ArrayListGrower();
/*  31 */   private final ArrayListGrower<ACTION.ACTION_O<Path>> afterSave = new ArrayListGrower();
/*  32 */   private final ArrayListGrower<ACTION.ACTION_O<Path>> beforeLoad = new ArrayListGrower();
/*  33 */   private final ArrayListGrower<ACTION.ACTION_O<Path>> afterLoad = new ArrayListGrower();
/*     */   
/*  35 */   private final PROP prop = new PROP(this);
/*  36 */   private final AutoSaver auto = new AutoSaver(this);
/*     */   
/*     */   private double timeOfLastSave;
/*  39 */   private static CharSequence ¤¤save = "Saving";
/*  40 */   private static CharSequence ¤¤savingDisk = "Saving to disk, please wait.";
/*     */   static {
/*  42 */     D.ts(GameSaver.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public GameSaver(GAME game) {
/*  47 */     add(this.prop);
/*  48 */     this.timeOfLastSave = CORE.getUpdateInfo().getSecondsSinceFirstUpdate();
/*     */   }
/*     */ 
/*     */   
/*     */   public Path save(String name) {
/*  53 */     return save(name, false);
/*     */   }
/*     */   
/*     */   public Path save(String name, boolean minified) {
/*  57 */     return save(PATHS.local().save().get(), name, minified);
/*     */   }
/*     */   
/*     */   public Path save(Path path, String name, boolean minified) {
/*  61 */     path = path.resolve(name + name);
/*  62 */     boolean succ = false;
/*  63 */     SPRITES.loader().minify(minified, ¤¤save);
/*  64 */     SPRITES.loader().init();
/*  65 */     SPRITES.loader().print("Saving the world...");
/*  66 */     this.auto.reset();
/*     */     try {
/*  68 */       if (Files.exists(path, new java.nio.file.LinkOption[0])) {
/*  69 */         Files.delete(path);
/*     */       }
/*     */ 
/*     */       
/*  73 */       FilePutter fp = new FilePutter(path, 120 * SETT.TAREA);
/*  74 */       save(fp);
/*  75 */       CORE.checkIn();
/*  76 */       ACTION a = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  80 */             SPRITES.loader().print(GameSaver.¤¤savingDisk);
/*     */           }
/*     */         };
/*  83 */       a.exe();
/*  84 */       succ = fp.zip(a);
/*  85 */       this.timeOfLastSave = CORE.getUpdateInfo().getSecondsSinceFirstUpdate();
/*  86 */       System.gc();
/*  87 */       CORE.getInput().clearAllInput();
/*  88 */       SPRITES.loader().minify(false, ¤¤save);
/*  89 */       this.auto.reset();
/*  90 */       System.gc();
/*  91 */       return succ ? path : null;
/*     */     }
/*  93 */     catch (IOException e) {
/*  94 */       e.printStackTrace();
/*  95 */       SPRITES.loader().minify(false, ¤¤save);
/*  96 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void save(FilePutter f) {
/* 102 */     for (ACTION.ACTION_O<Path> a : this.beforeSave) {
/* 103 */       a.exe(f.path);
/*     */     }
/* 105 */     GameSpec.save(f);
/* 106 */     save(f, (LIST<Savable>)this.before);
/* 107 */     save(f, (LIST<Savable>)this.all);
/*     */     
/* 109 */     for (ACTION.ACTION_O<Path> a : this.afterSave) {
/* 110 */       a.exe(f.path);
/*     */     }
/*     */   }
/*     */   
/*     */   private void save(FilePutter f, LIST<Savable> li) {
/* 115 */     f.i(li.size());
/* 116 */     for (Savable s : li) {
/* 117 */       String k = s.key;
/* 118 */       f.chars(k);
/* 119 */       int pos = f.getPosition();
/* 120 */       f.i(0);
/* 121 */       s.save(f);
/* 122 */       int le = f.getPosition() - pos - 4;
/* 123 */       f.setAtPosition(pos, le);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void load(FileGetter f) throws IOException {
/* 131 */     for (ACTION.ACTION_O<Path> a : this.beforeLoad) {
/* 132 */       a.exe(f.path);
/*     */     }
/* 134 */     load(f, (LIST<Savable>)this.before);
/* 135 */     load(f, (LIST<Savable>)this.all);
/*     */     
/* 137 */     for (ACTION.ACTION_O<Path> a : this.afterLoad) {
/* 138 */       a.exe(f.path);
/*     */     }
/*     */   }
/*     */   
/*     */   private void load(FileGetter f, LIST<Savable> li) throws IOException {
/* 143 */     KeyMap<Savable> map = new KeyMap();
/* 144 */     for (Savable e : li) {
/* 145 */       map.put(e.key, e);
/*     */     }
/*     */     
/* 148 */     int am = f.i();
/* 149 */     for (int i = 0; i < am; i++) {
/* 150 */       String k = f.chars();
/* 151 */       int pos = f.getPosition() + f.i() + 4;
/* 152 */       Savable e = (Savable)map.get(k);
/* 153 */       if (e != null) {
/*     */         try {
/* 155 */           e.load(f);
/* 156 */         } catch (Exception ee) {
/* 157 */           ee.printStackTrace(System.out);
/* 158 */           LOG.ln(k + " " + k + " " + f.getPosition() + " " + pos);
/* 159 */           f.setPosition(pos);
/* 160 */           e.loadFail();
/*     */         } 
/*     */         
/* 163 */         CORE.checkIn();
/* 164 */         if (f.getPosition() != pos) {
/* 165 */           LOG.ln(k + " " + k + " " + f.getPosition() + " " + pos);
/* 166 */           f.setPosition(pos);
/* 167 */           e.loadFail();
/*     */         } 
/*     */       } else {
/* 170 */         LOG.ln("skipping " + k);
/* 171 */         f.setPosition(pos);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getTimeSinceLastSave() {
/* 180 */     return CORE.getUpdateInfo().getSecondsSinceFirstUpdate() - this.timeOfLastSave;
/*     */   }
/*     */   
/*     */   public void quicksave() {
/* 184 */     saveNamed("QuickSave", 3, true);
/*     */   }
/*     */   
/*     */   public void saveNew() {
/* 188 */     saveNamed("A New Beginning", 3, false);
/*     */   }
/*     */   
/*     */   public boolean saveNamed(String sname, int max, boolean mini) {
/* 192 */     if (!VIEW.canSave())
/* 193 */       return false; 
/* 194 */     int am = 0; byte b; int i; String[] arrayOfString;
/* 195 */     for (i = (arrayOfString = PATHS.local().save().getFiles()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 196 */       if (SaveFile.name(s).equals(sname))
/* 197 */         am++; 
/*     */       b++; }
/*     */     
/* 200 */     while (am >= max) {
/* 201 */       String least = null; String[] arrayOfString1;
/* 202 */       for (int j = (arrayOfString1 = PATHS.local().save().getFiles()).length; i < j; ) { String s = arrayOfString1[i];
/* 203 */         if (SaveFile.name(s).equals(sname) && (
/* 204 */           least == null || SaveFile.time(s) < SaveFile.time(least))) {
/* 205 */           least = s;
/*     */         }
/*     */         i++; }
/*     */       
/* 209 */       am--;
/* 210 */       PATHS.local().save().delete(least);
/*     */     } 
/* 212 */     return (save(SaveFile.stamp(sname), mini) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void autoSave(double ds) {
/* 218 */     this.auto.autosave(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSpecialSaver(Savable s) {
/* 223 */     this.before.add(s);
/* 224 */     this.smap.put(s.key, s);
/*     */   }
/*     */   
/*     */   public void add(Savable s) {
/* 228 */     this.all.add(s);
/* 229 */     this.smap.put(s.key, s);
/*     */   }
/*     */   
/*     */   public void onBeforeSave(ACTION.ACTION_O<Path> a) {
/* 233 */     this.beforeSave.add(a);
/*     */   }
/*     */   
/*     */   public void onAfterSave(ACTION.ACTION_O<Path> a) {
/* 237 */     this.afterSave.add(a);
/*     */   }
/*     */   
/*     */   public void onBeforeLoad(ACTION.ACTION_O<Path> a) {
/* 241 */     this.beforeLoad.add(a);
/*     */   }
/*     */   
/*     */   public void onAfterLoad(ACTION.ACTION_O<Path> a) {
/* 245 */     this.afterLoad.add(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\GameSaver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */