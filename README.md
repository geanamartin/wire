"Omar" Little Protocol Buffers
==============================
*“A man got to have a code!”* - Omar Little

Introduction
------------

Omar is a library for lightweight protocol Buffers for mobile Java. Code generated by Omar has many fewer methods than standard protocol buffer code, which helps applications avoid the notorious 64k limit on methods in Android applications. Omar also generates clean, human-readable code for protocol buffer messages.

Compiling .proto files
----------------------
The compiler/ package contains the OmarCompiler class, which compiles standard .proto files into Java.

For example, to compile the file protos-repo/google/protobuf/descriptor.proto, which may (recursively) import
other .proto files within the protos-repo/ directory:

    % mvn clean package

    % java -jar compiler/target/omar-compiler-0.1-SNAPSHOT.jar --proto_path=protos-repo --java_out=out google/protobuf/descriptor.proto
	Reading proto source file protos-repo/google/protobuf/descriptor.proto
	Writing generated code to out/com/google/protobuf/DescriptorProtos.java
	
	# The output has been written to out/com/google/protobuf/DescriptorProtos.java
	% head -18 out/com/google/protobuf/DescriptorProtos.java
	/**
	 * Code generated by Square Omar protobuf compiler, do not edit.
	 * Source file: protos-repo/google/protobuf/descriptor.proto
	 */
	package com.google.protobuf;

	import com.squareup.omar.Message;
	import com.squareup.omar.Omar;
	import com.squareup.omar.ProtoEnum;
	import com.squareup.omar.ProtoField;
	import com.squareup.omar.UninitializedMessageException;
	import java.util.Collections;
	import java.util.List;
	import java.util.Map;
	import java.util.TreeMap;

	public final class DescriptorProtos {
		
Instead of supplying individual filename arguments on the command line, the --files flag may be used to specify a single file containing a list of .proto files. The file names are interpreted relative to the value given for the --proto_path flag.

    % cat protos.include
    google/protobuf/descriptor.proto
    yourcompany/protos/stuff.proto
    ...

    % java -jar compiler/target/omar-compiler-0.1-SNAPSHOT.jar --proto_path=protos-repo --java_out=out --files=protos.include
    Reading proto source file protos-repo/google/protobuf/descriptor.proto
	Writing generated code to out/com/google/protobuf/DescriptorProtos.java
	Reading proto source file protos-repo/yourcompany/protos/stuff.proto
	Writing generated code to out/com/yourcompany/protos/stuff/Stuff.java
	...

Using Omar in your application
------------------------------

The runtime/ package contains runtime support libraries that must be included in applications that use Omar-generated code.

The code in com.google.protobuf.nano is taken from the Android Open Source repo, with modifications.

For Maven projects, simply add omar-runtime as a dependency:

    <dependency>
      <groupId>com.squareup</groupId>
      <artifactId>omar-runtime</artifactId>
      <version>0.1-SNAPSHOT</version>
    </dependency>

Future work
-----------
Some things that aren't implemented:

* Groups
* Immutable byte array wrappers
* Unknown fields
* Services
