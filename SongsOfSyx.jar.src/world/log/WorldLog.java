/*     */ package world.log;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ 
/*     */ public final class WorldLog
/*     */   extends WORLD.WorldResource {
/*     */   public final int MAX = 256;
/*     */   private final ArrayList<LogEntry> all;
/*     */   private WORLD.WorldResourceManager saver;
/*  23 */   private static CharSequence ¤¤war = "The {0} declares war on {1}";
/*     */   static {
/*  25 */     D.ts(WorldLog.class);
/*     */   }
/*     */   
/*  28 */   public WorldLog() { super("log", "WLOGs");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     this.MAX = 256;
/*  46 */     this.all = new ArrayList(256);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  88 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  92 */           file.i(WorldLog.this.all.size());
/*  93 */           for (LogEntry e : WorldLog.this.all) {
/*  94 */             e.save(file);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 101 */           int am = file.i();
/* 102 */           WorldLog.this.all.clear();
/* 103 */           for (int i = 0; i < am; i++) {
/* 104 */             WorldLog.this.all.add(new LogEntry(file));
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {
/* 111 */           WorldLog.this.all.clearSloppy();
/*     */         }
/*     */       }; }
/*     */ 
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/* 117 */     return this.saver;
/*     */   }
/*     */   
/*     */   private LogEntry next() {
/*     */     if (!this.all.hasRoom()) {
/*     */       LogEntry e = (LogEntry)this.all.get(0);
/*     */       this.all.shiftLeft();
/*     */       return e;
/*     */     } 
/*     */     return new LogEntry();
/*     */   }
/*     */   
/*     */   public void log(Faction a, Faction b, Icons.S.IconS icon, CharSequence message, int tx, int ty) {
/*     */     int day = TIME.days().bitsSinceStart();
/*     */     short fa = (short)((a == null) ? -1 : a.index());
/*     */     short fb = (short)((b == null) ? -1 : b.index());
/*     */     short ii = (short)((icon == null) ? -1 : icon.index);
/*     */     for (int i = this.all.size() - 1; i >= 0; i--) {
/*     */       LogEntry o = (LogEntry)this.all.get(i);
/*     */       if (o.day != day)
/*     */         break; 
/*     */       if (o.ii == ii && o.fa == fa && o.fb == fb && o.message.equals(message))
/*     */         return; 
/*     */     } 
/*     */     LogEntry e = next();
/*     */     e.ii = ii;
/*     */     e.day = day;
/*     */     e.fa = fa;
/*     */     e.fb = fb;
/*     */     e.tx = (short)tx;
/*     */     e.ty = (short)ty;
/*     */     e.message.clear().add(message);
/*     */     this.all.add(e);
/*     */   }
/*     */   
/*     */   public LIST<LogEntry> all() {
/*     */     return (LIST<LogEntry>)this.all;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\log\WorldLog.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */